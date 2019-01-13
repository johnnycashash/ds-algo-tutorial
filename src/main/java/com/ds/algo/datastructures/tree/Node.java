package com.ds.algo.datastructures.tree;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value == data) {
            return;
        }
        if (value < data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public void inorderTraversal() {
        if (left != null) {
            left.inorderTraversal();
        }
        System.out.println(data);
        if (right != null) {
            right.inorderTraversal();
        }
    }
    public void preorderTraversal() {
        System.out.println(data);
        if (left != null) {
            left.inorderTraversal();
        }
        if (right != null) {
            right.inorderTraversal();
        }
    }

    public void postorderTraversal() {
        if (left != null) {
            left.inorderTraversal();
        }
        if (right != null) {
            right.inorderTraversal();
        }
        System.out.println(data);
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


}
