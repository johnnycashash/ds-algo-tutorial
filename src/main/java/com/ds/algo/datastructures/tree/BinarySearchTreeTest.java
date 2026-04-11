package com.ds.algo.datastructures.tree;

/** Demo: BST insert, search, all traversals. */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTreeUtils bst = new BinarySearchTreeUtils();
        BinarySearchTreeUtils.TreeNode root = null;

        //       5
        //      / \
        //     3   7
        //    / \ / \
        //   2  4 6  8
        for (int val : new int[]{5, 3, 7, 2, 4, 6, 8}) {
            root = bst.insertBST(root, val);
        }

        System.out.println("── Tree ──");
        bst.printTree(root);

        System.out.println("\nHeight   : " + bst.getHeight(root));  // 3
        System.out.println("Search 4 : " + bst.search(root, 4));    // true
        System.out.println("Search 9 : " + bst.search(root, 9));    // false

        System.out.print("\nIn-order   : "); bst.inorder(root);     // 2 3 4 5 6 7 8
        System.out.print("\nPre-order  : "); bst.preorder(root);    // 5 3 2 4 7 6 8
        System.out.print("\nPost-order : "); bst.postorder(root);   // 2 4 3 6 8 7 5
        System.out.print("\nLevel-order: "); bst.levelOrder(root);  // 5 3 7 2 4 6 8
        System.out.println();
    }
}
