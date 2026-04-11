package com.ds.algo.datastructures.list;

/**
 * Singly Linked List (with Employee data).
 *
 * KEY OPERATIONS:
 *   addToFront    – O(1)  (new head)
 *   removeFromFront – O(1) (pop head)
 *   printList     – O(n)
 *
 * Interview tip: Always handle the empty-list edge case!
 */
public class EmployeeLinkedList {
    private EmployeeNode head;
    private int size;

    /** Insert at the head – O(1). */
    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    /** Remove from head – O(1). */
    public Employee removeFromFront() {
        if (isEmpty()) return null;
        EmployeeNode removed = head;
        head = head.getNext();
        removed.setNext(null);       // help GC
        size--;
        return removed.getEmployee();
    }

    public int getSize()    { return size; }
    public boolean isEmpty() { return head == null; }

    public void printList() {
        EmployeeNode current = head;
        while (current != null) {
            System.out.println("  " + current);
            current = current.getNext();
        }
    }
}
