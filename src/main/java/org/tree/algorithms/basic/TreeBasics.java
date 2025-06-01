package org.tree.algorithms.basic;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeBasics {

    // 1. Inorder Traversal (Recursive)
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    // 2. Preorder Traversal (Recursive)
    public void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // 3. Postorder Traversal (Recursive)
    public void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val + " ");
        }
    }

    // 4. Level Order Traversal (BFS)
    public void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    // 5. Height of Tree
    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // 6. Count Leaf Nodes
    public int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // 6b. Count Internal Nodes
    public int countInternal(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        return 1 + countInternal(root.left) + countInternal(root.right);
    }

    // 7. Mirror / Invert Tree
    public TreeNode invert(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 8. Check if Two Trees are Identical
    public boolean isIdentical(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val) && isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
    }

    // ---------- Main Example ----------
    public static void main(String[] args) {
        TreeBasics tb = new TreeBasics();

        /* Sample Tree
                  1
                 / \
                2   3
               / \   \
              4   5   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.print("Inorder: ");
        tb.inorder(root);
        System.out.println();
        System.out.print("Preorder: ");
        tb.preorder(root);
        System.out.println();
        System.out.print("Postorder: ");
        tb.postorder(root);
        System.out.println();
        System.out.print("Level Order: ");
        tb.levelOrder(root);
        System.out.println();
        System.out.println("Height: " + tb.height(root));
        System.out.println("Leaf Nodes: " + tb.countLeaves(root));
        System.out.println("Internal Nodes: " + tb.countInternal(root));

        TreeNode inverted = tb.invert(root);
        System.out.print("Inverted Inorder: ");
        tb.inorder(inverted);
        System.out.println();

        TreeNode rootCopy = new TreeNode(1);
        rootCopy.left = new TreeNode(2);
        rootCopy.right = new TreeNode(3);
        rootCopy.left.left = new TreeNode(4);
        rootCopy.left.right = new TreeNode(5);
        rootCopy.right.right = new TreeNode(6);

        System.out.println("Are trees identical? " + tb.isIdentical(root, rootCopy));
    }
}

