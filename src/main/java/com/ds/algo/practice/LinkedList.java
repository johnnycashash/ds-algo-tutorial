package com.ds.algo.practice;

/**
 * Linked List – common interview problems.
 *
 * PROBLEMS COVERED:
 *   1. Reverse a linked list          – O(n) time, O(1) space
 *   2. Find middle node (slow/fast)   – O(n) time, O(1) space
 *   3. Detect cycle (Floyd's algo)    – O(n) time, O(1) space
 */
public class LinkedList {
    private Node head;

    public static class Node {
        String data;
        Node next;
        Node(String data) { this.data = data; }
    }

    // ────────── Basic Operations ──────────

    /** Insert at head – O(1). */
    public void addToFront(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    /** Remove from head – O(1). */
    public void removeFromFront() {
        if (head != null) head = head.next;
    }

    // ────────── Interview Problem 1: Reverse ──────────

    /**
     * Reverse a singly linked list in-place.
     * Use THREE pointers: prev, current, nextNode.
     *
     *   null ← 1 ← 2 ← 3    (prev moves right, current moves right)
     */
    public static Node reverse(Node head) {
        Node prev = null, current = head;
        while (current != null) {
            Node nextNode = current.next;   // save next
            current.next = prev;            // reverse pointer
            prev = current;                 // advance prev
            current = nextNode;             // advance current
        }
        return prev;    // new head
    }

    // ────────── Interview Problem 2: Find Middle ──────────

    /**
     * Find middle using slow & fast pointers.
     * Slow moves 1 step, fast moves 2 steps.
     * When fast reaches end, slow is at middle.
     */
    public static Node findMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // ────────── Interview Problem 3: Detect Cycle ──────────

    /**
     * Floyd's Cycle Detection (Tortoise and Hare).
     * If slow == fast at any point → cycle exists.
     */
    public static boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;  // cycle detected!
        }
        return false;   // no cycle
    }

    // ────────── Utility ──────────

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ────────── Demo ──────────

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 5; i >= 1; i--) list.addToFront(String.valueOf(i));

        System.out.print("Original : ");
        printList(list.head);                           // 1→2→3→4→5→null

        System.out.println("Middle   : " + findMiddle(list.head).data);  // 3

        list.head = reverse(list.head);
        System.out.print("Reversed : ");
        printList(list.head);                           // 5→4→3→2→1→null

        System.out.println("Has cycle: " + hasCycle(list.head));         // false

        // Create a cycle for testing: 1→2→3→1...
        Node a = new Node("1"), b = new Node("2"), c = new Node("3");
        a.next = b; b.next = c; c.next = a;
        System.out.println("Cycle test: " + hasCycle(a));                // true
    }
}
