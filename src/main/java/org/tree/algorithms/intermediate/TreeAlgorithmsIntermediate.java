package org.tree.algorithms.intermediate;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class TreeAlgorithmsIntermediate {

    // 1. Lowest Common Ancestor (Binary Tree)
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return (left != null && right != null) ? root : (left != null ? left : right);
    }

    // 2. Validate a BST
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    // 3. Diameter of Binary Tree
    static int diameter = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        depth(root);
        return diameter;
    }
    private static int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }

    // 4. Build Tree from Inorder and Preorder
    static int preIndex = 0;
    public static TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        preIndex = 0;
        return build(preorder, inorder, 0, inorder.length - 1, map);
    }
    private static TreeNode build(int[] pre, int[] in, int start, int end, Map<Integer, Integer> map) {
        if (start > end) return null;
        TreeNode root = new TreeNode(pre[preIndex++]);
        int inIndex = map.get(root.val);
        root.left = build(pre, in, start, inIndex - 1, map);
        root.right = build(pre, in, inIndex + 1, end, map);
        return root;
    }

    //  5. Zigzag / Spiral Level Order Traversal
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) level.addLast(node.val);
                else level.addFirst(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }

    //  6. Left View of Binary Tree
    public static List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        leftViewHelper(root, result, 0);
        return result;
    }
    private static void leftViewHelper(TreeNode node, List<Integer> result, int level) {
        if (node == null) return;
        if (level == result.size()) result.add(node.val);
        leftViewHelper(node.left, result, level + 1);
        leftViewHelper(node.right, result, level + 1);
    }

    // 7. Right View of Binary Tree
    public static List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightViewHelper(root, result, 0);
        return result;
    }
    private static void rightViewHelper(TreeNode node, List<Integer> result, int level) {
        if (node == null) return;
        if (level == result.size()) result.add(node.val);
        rightViewHelper(node.right, result, level + 1);
        rightViewHelper(node.left, result, level + 1);
    }

    //  8. Maximum and Minimum Depth
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    //  Main method to run and test all algorithms
    public static void main(String[] args) {
        /*
                      3
                    /   \
                   5     1
                  / \   / \
                 6   2 0   8
                    / \
                   7   4
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // LCA
        System.out.println("LCA of 5 and 1: " + lowestCommonAncestor(root, root.left, root.right).val); // 3

        // Validate BST
        System.out.println("Is valid BST: " + isValidBST(root)); // false

        // Diameter
        System.out.println("Diameter of tree: " + diameterOfBinaryTree(root)); // 6

        // Build Tree from Preorder and Inorder
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode builtTree = buildTreeFromPreIn(preorder, inorder);
        System.out.println("Built tree root from preorder/inorder: " + builtTree.val); // 3

        // Zigzag
        System.out.println("Zigzag Level Order: " + zigzagLevelOrder(root));

        // Left and Right Views
        System.out.println("Left View: " + leftView(root));   // [3, 5, 6, 7]
        System.out.println("Right View: " + rightView(root)); // [3, 1, 8, 4]

        // Max and Min Depth
        System.out.println("Max Depth: " + maxDepth(root)); // 4
        System.out.println("Min Depth: " + minDepth(root)); // 2
    }
}

