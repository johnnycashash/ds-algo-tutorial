package com.ds.algo.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTreeUtils {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    // Print tree visually (top-down, left and right children)
    void printTree(TreeNode root) {
        printTreeHelper(root, "", true);
    }

    private void printTreeHelper(TreeNode node, String prefix, boolean isTail) {
        if (node == null) return;

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.data);

        if (node.left != null || node.right != null) {
            if (node.right != null)
                printTreeHelper(node.right, prefix + (isTail ? "    " : "│   "), node.left == null);
            if (node.left != null)
                printTreeHelper(node.left, prefix + (isTail ? "    " : "│   "), true);
        }
    }

    //insert using level order

    public TreeNode insertBinaryTree(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) return newNode;

        Queue<TreeNode> q = new java.util.LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left == null) {
                node.left = newNode;
                break;
            } else q.offer(node.left);

            if (node.right == null) {
                node.right = newNode;
                break;
            } else q.offer(node.right);
        }
        return root;
    }

    public TreeNode insertBinarySearchTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val); // create node

        if (val < root.data) {
            root.left = insertBinarySearchTree(root.left, val);
        } else if (val > root.data) {
            root.right = insertBinarySearchTree(root.right, val);
        }
        // if equal, ignore or handle duplicates as needed
        return root;
    }

    //DFS
    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // BFS (Level-order Traversal)
    void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }
}
