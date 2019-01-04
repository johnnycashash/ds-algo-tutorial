package com.ds.algo.list;

import com.ds.algo.Employee;

public class EmployeeLinkedList {
    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public Employee removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        EmployeeNode removeNode = head;
        head = head.getNext();
        size--;
        removeNode.setNext(null);
        return removeNode.getEmployee();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void printList() {
        EmployeeNode current = head;
        while (current != null) {
            System.out.println(current.getEmployee());
            current = current.getNext();
        }
    }

    public boolean isEmpty() {
        return head == null;
        //or size is 0
    }
}
