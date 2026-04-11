package com.ds.algo.datastructures.list;

/** Demo: Singly linked list operations. */
public class TestEmployeeLinkedList {
    public static void main(String[] args) {
        EmployeeLinkedList list = new EmployeeLinkedList();
        list.addToFront(new Employee(1, "Alice", "A"));
        list.addToFront(new Employee(2, "Bob", "B"));
        list.addToFront(new Employee(3, "Charlie", "C"));
        list.addToFront(new Employee(4, "Diana", "D"));

        System.out.println("── After 4 inserts ──");
        list.printList();
        System.out.println("Size: " + list.getSize());     // 4

        System.out.println("\nRemoved: " + list.removeFromFront());  // Diana
        System.out.println("\n── After remove ──");
        list.printList();
        System.out.println("Size: " + list.getSize());     // 3
        System.out.println("Empty? " + list.isEmpty());    // false
    }
}
