package com.ds.algo.datastructures.queue.array;

import java.util.NoSuchElementException;

public class ArrayQueue {
    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if (isFull()) {
            Employee[] newQueue = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }
        queue[back++] = employee;
    }

    public Employee remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Employee removedEmployee = queue[front];
        queue[front++] = null;
        if (isEmpty()) {
            front = 0;
            back = 0;
        }
        return removedEmployee;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public int size() {
        return back - front;
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    private boolean isFull() {
        return back == queue.length;
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
