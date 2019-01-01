package com.ds.algo.stack.linkedlist;

import com.ds.algo.Employee;

public class TestLinkedStack {
    public static void main(String[] args) {
        Employee a = new Employee(1, "FAAA", "LAAA");
        Employee b = new Employee(2, "FBBB", "LBBB");
        Employee c = new Employee(3, "FCCC", "LCCC");
        Employee d = new Employee(4, "FDDD", "LDDD");

        LinkedStack linkedStack = new LinkedStack();

        linkedStack.push(a);
        linkedStack.push(b);
        linkedStack.push(c);
        linkedStack.push(d);
        //linkedStack.printStack();
        //System.out.println(linkedStack.peek());
        //linkedStack.printStack();
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.peek());
    }

}
