package com.ds.algo.datastructures.stack.array;

public class TestArrayStack {
    public static void main(String[] args) {
        Employee a = new Employee(1, "FAAA", "LAAA");
        Employee b = new Employee(2, "FBBB", "LBBB");
        Employee c = new Employee(3, "FCCC", "LCCC");
        Employee d = new Employee(4, "FDDD", "LDDD");

        ArrayStack arrayStack=new ArrayStack(3);
        arrayStack.push(a);
        arrayStack.push(b);
        arrayStack.push(c);
        System.out.println(arrayStack.getStack().length);
        arrayStack.push(d);
        System.out.println(arrayStack.getStack().length);
        //arrayStack.printStack();
        //System.out.println(arrayStack.peek());
        //arrayStack.printStack();
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.peek());
    }
}
