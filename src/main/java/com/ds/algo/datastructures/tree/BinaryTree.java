package com.ds.algo.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    static void insert(Node temp, int key)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else
                q.add(temp.right);
        }
    }

    //need to design operations
    // BFS algos
    public void levelorderTraversal(Node root) {
        Queue<Node> traversal = new LinkedList();
        traversal.add(root);
        while (!traversal.isEmpty()) {
            System.out.println(traversal.poll());
            if (root.left != null) {
                traversal.add(root.left);
            }
            if (root.right != null) {
                traversal.add(root.right);
            }
        }
    }


    // DFS algos
    public void preorderTraversal(Node root) {
        if (root != null) {
            System.out.println(root.getData());
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.getData());
            inorderTraversal(root.right);
        }
    }

    public void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.println(root.getData());
        }
    }
}
