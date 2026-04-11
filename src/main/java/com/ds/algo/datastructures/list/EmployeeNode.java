package com.ds.algo.datastructures.list;

/**
 * Node wrapper for the Employee singly-linked list.
 */
public class EmployeeNode {
    private Employee employee;
    private EmployeeNode next;

    public EmployeeNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee()       { return employee; }
    public EmployeeNode getNext()       { return next; }
    public void setNext(EmployeeNode n) { this.next = n; }

    @Override
    public String toString() {
        return employee.toString();
    }
}
