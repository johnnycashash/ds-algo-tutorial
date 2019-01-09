package com.ds.algo.datastructures.list;

public class TestEmployeeLinkedList {
    public static void main(String[] args) {
        Employee a = new Employee(1, "FAAA", "LAAA");
        Employee b = new Employee(2, "FBBB", "LBBB");
        Employee c = new Employee(3, "FCCC", "LCCC");
        Employee d = new Employee(4, "FDDD", "LDDD");

        EmployeeLinkedList employeeLinkedList = new EmployeeLinkedList();
        employeeLinkedList.addToFront(a);
        employeeLinkedList.addToFront(b);
        employeeLinkedList.addToFront(c);
        employeeLinkedList.addToFront(d);
        employeeLinkedList.removeFromFront();
        employeeLinkedList.printList();
        System.out.println(employeeLinkedList.isEmpty());
        System.out.println(employeeLinkedList.getSize());
    }
}
