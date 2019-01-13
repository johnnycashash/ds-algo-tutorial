package com.ds.algo.datastructures.queue.array;

public class TestArrayQueue {
    public static void main(String[] args) {
        Employee a = new Employee(1, "FAAA", "LAAA");
        Employee b = new Employee(2, "FBBB", "LBBB");
        Employee c = new Employee(3, "FCCC", "LCCC");
        Employee d = new Employee(4, "FDDD", "LDDD");

        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.add(a);
        arrayQueue.add(b);
        arrayQueue.add(c);
        System.out.println(arrayQueue.size());
        arrayQueue.add(d);
        System.out.println(arrayQueue.size());
        //arrayQueue.printStack();
        //System.out.println(arrayQueue.peek());
        //arrayQueue.printStack();
        System.out.println(arrayQueue.remove());
        System.out.println(arrayQueue.peek());
    }
}
