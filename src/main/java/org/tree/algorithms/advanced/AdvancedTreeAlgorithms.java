package org.tree.algorithms.advanced;



import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class AdvancedTreeAlgorithms {

    //  1. Kth Smallest Element in BST
    static int count = 0, result = -1;
    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        inorder(root, k);
        return result;
    }
    private static void inorder(TreeNode node, int k) {
        if (node == null) return;
        inorder(node.left, k);
        count++;
        if (count == k) result = node.val;
        inorder(node.right, k);
    }

    //  2. Morris Inorder Traversal
    public static List<Integer> morrisTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }

    //  3. Serialize and Deserialize Tree
    public static String serialize(TreeNode root) {
        if (root == null) return "null,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }
    static int index;
    public static TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        index = 0;
        return buildTree(vals);
    }
    private static TreeNode buildTree(String[] vals) {
        if (vals[index].equals("null")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[index++]));
        node.left = buildTree(vals);
        node.right = buildTree(vals);
        return node;
    }

    //  4. Binary Tree to Doubly Linked List
    static TreeNode prev = null, head = null;
    public static TreeNode bToDLL(TreeNode root) {
        prev = null;
        head = null;
        convertToDLL(root);
        return head;
    }
    private static void convertToDLL(TreeNode root) {
        if (root == null) return;
        convertToDLL(root.left);
        if (prev == null) head = root;
        else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        convertToDLL(root.right);
    }

    //  5. Flatten Binary Tree to Linked List
    public static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode curr = root;
        while (curr.right != null) curr = curr.right;
        curr.right = right;
    }

    //  6. Max Path Sum (Tree DP)
    static int maxSum = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }
    private static int maxGain(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxGain(node.left));
        int right = Math.max(0, maxGain(node.right));
        maxSum = Math.max(maxSum, left + right + node.val);
        return node.val + Math.max(left, right);
    }

    //  Main to Test Some Algorithms
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println("Kth Smallest (3rd): " + kthSmallest(root, 3));
        System.out.println("Morris Inorder: " + morrisTraversal(root));

        String ser = serialize(root);
        System.out.println("Serialized: " + ser);
        TreeNode deser = deserialize(ser);
        System.out.println("Deserialized Tree Root: " + deser.val);

        TreeNode dll = bToDLL(root);
        System.out.print("Doubly Linked List: ");
        for (TreeNode curr = dll; curr != null; curr = curr.right) {
            System.out.print(curr.val + " <-> ");
        }
        System.out.println("null");

        TreeNode flattenRoot = new TreeNode(1);
        flattenRoot.left = new TreeNode(2);
        flattenRoot.right = new TreeNode(5);
        flattenRoot.left.left = new TreeNode(3);
        flattenRoot.left.right = new TreeNode(4);
        flatten(flattenRoot);
        System.out.print("Flattened Tree: ");
        while (flattenRoot != null) {
            System.out.print(flattenRoot.val + " -> ");
            flattenRoot = flattenRoot.right;
        }
        System.out.println("null");

        TreeNode rootSum = new TreeNode(-10);
        rootSum.left = new TreeNode(9);
        rootSum.right = new TreeNode(20);
        rootSum.right.left = new TreeNode(15);
        rootSum.right.right = new TreeNode(7);
        System.out.println("Max Path Sum: " + maxPathSum(rootSum));
    }
}

