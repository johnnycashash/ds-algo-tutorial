package com.ds.algo.datastructures.queue.array;

import java.util.Arrays;

public class EmployeeQueue {
    EmployeeCQ[] queue;
    int front;
    int back;
    int size;

    EmployeeQueue(int capacity) {
        queue = new EmployeeCQ[capacity];
        front = -1;
        back = -1;
        size = 0;
    }

    public void add(Integer data) {
        if (size == queue.length) {
            System.out.println("Queue full");
            return;
        }
        back = (back + 1) % queue.length;
        EmployeeCQ employee = new EmployeeCQ(data);
        queue[back] = employee;
        if (front == -1) {
            front = 0;
        }
        size++;
    }

    public Integer remove() {
        if (size == 0) {
            System.out.println("Empty");
            return null;
        }
        Integer dataToBeRemoved = queue[front].data;
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        return dataToBeRemoved;
    }

    @Override
    public String toString() {
        return "EmployeeQueue{" +
                "queue=" + Arrays.toString(queue) +
                '}';
    }
}
