package com.ds.algo.datastructures.queue.array;

public class QueueClient {
    public static void main(String[] args) {
        EmployeeQueue employeeQueue = new EmployeeQueue(5);
        employeeQueue.add(1);
        employeeQueue.add(2);
        employeeQueue.add(3);
        employeeQueue.add(4);
        employeeQueue.add(5);
        employeeQueue.add(6);
        System.out.println(employeeQueue.remove());
        employeeQueue.add(7);
        System.out.println(employeeQueue);
        System.out.println(employeeQueue.remove());
        System.out.println(employeeQueue.remove());
        System.out.println(employeeQueue.remove());
        System.out.println(employeeQueue.remove());
        System.out.println(employeeQueue.remove());
        System.out.println(employeeQueue.remove());
        employeeQueue.add(7);
        System.out.println(employeeQueue.remove());

        System.out.println(employeeQueue);

    }
}
