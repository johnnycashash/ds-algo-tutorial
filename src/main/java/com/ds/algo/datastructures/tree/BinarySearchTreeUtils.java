package com.ds.algo.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Search Tree (BST) – essential interview topic.
 *
 * KEY PROPERTIES:
 *   - Left child < parent < Right child (for every node).
 *   - Inorder traversal gives SORTED order.
 *
 * ┌─────────────────────────────────────────────────────────────┐
 * │ Operation        │  Average  │  Worst (skewed)              │
 * │ Search/Insert    │  O(log n) │  O(n)                        │
 * │ DFS traversals   │  O(n)     │  O(n)                        │
 * │ BFS (level-order)│  O(n)     │  O(n)                        │
 * └─────────────────────────────────────────────────────────────┘
 *
 * TRAVERSAL MNEMONICS:
 *   Pre-order  → Root, Left, Right  (NLR)  – useful for copying a tree
 *   In-order   → Left, Root, Right  (LNR)  – gives sorted order in BST
 *   Post-order → Left, Right, Root  (LRN)  – useful for deleting a tree
 *   Level-order → BFS with a Queue
 */
public class BinarySearchTreeUtils {

    /** Tree node. */
    public static class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int data) { this.data = data; }
    }

    // ────────── INSERT ──────────

    /** Insert into a BST (recursive). */
    public TreeNode insertBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.data)      root.left  = insertBST(root.left, val);
        else if (val > root.data) root.right = insertBST(root.right, val);
        // duplicates ignored
        return root;
    }

    /** Insert into a generic Binary Tree using level-order (fills left → right). */
    public TreeNode insertBT(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) return newNode;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left == null)  { node.left  = newNode; return root; }
            else q.offer(node.left);
            if (node.right == null) { node.right = newNode; return root; }
            else q.offer(node.right);
        }
        return root;
    }

    // ────────── SEARCH ──────────

    /** Search in BST – O(log n) average. */
    public boolean search(TreeNode root, int val) {
        if (root == null) return false;
        if (val == root.data) return true;
        return val < root.data ? search(root.left, val) : search(root.right, val);
    }

    // ────────── HEIGHT ──────────

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    // ────────── DFS TRAVERSALS ──────────

    /** Pre-order: Root → Left → Right */
    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /** In-order: Left → Root → Right  (sorted for BST) */
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    /** Post-order: Left → Right → Root */
    public void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // ────────── BFS ──────────

    /** Level-order (BFS) using a queue. */
    public void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left  != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    // ────────── PRETTY PRINT ──────────

    public void printTree(TreeNode root) {
        printHelper(root, "", true);
    }

    private void printHelper(TreeNode node, String prefix, boolean isTail) {
        if (node == null) return;
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.data);
        String childPrefix = prefix + (isTail ? "    " : "│   ");
        if (node.right != null) printHelper(node.right, childPrefix, node.left == null);
        if (node.left  != null) printHelper(node.left,  childPrefix, true);
    }
}
