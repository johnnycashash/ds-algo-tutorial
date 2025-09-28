package com.ds.algo.datastructures.tree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTreeUtils.TreeNode root = new BinarySearchTreeUtils.TreeNode(5);
        BinarySearchTreeUtils tree = new BinarySearchTreeUtils();
        tree.insertBinarySearchTree(root, 3);
        tree.insertBinarySearchTree(root, 7);
        tree.insertBinarySearchTree(root, 2);
        tree.insertBinarySearchTree(root, 4);
        tree.insertBinarySearchTree(root, 6);
        tree.insertBinarySearchTree(root, 8);
        tree.printTree(root);
        System.out.println("\n----------");
        tree.inorder(root);
        System.out.println("\n----------");
        tree.preorder(root);
        System.out.println("\n----------");
        tree.postorder(root);
        System.out.println("\n----------");
        tree.levelOrder(root);
        System.out.println("\n----------");
    }
}
