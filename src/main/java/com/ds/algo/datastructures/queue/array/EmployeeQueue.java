package com.ds.algo.datastructures.queue.array;

import java.util.Arrays;

/**
 * Circular Queue (fixed-size) – classic interview implementation.
 *
 * KEY IDEA: front and back pointers wrap around using modulo.
 * When size == capacity, the queue is full.
 *
 * Time: enqueue/dequeue O(1)  Space: O(capacity)
 */
public class EmployeeQueue {
    private final EmployeeCQ[] queue;
    private int front = -1;
    private int back = -1;
    private int size = 0;

    EmployeeQueue(int capacity) {
        queue = new EmployeeCQ[capacity];
    }

    public void add(Integer data) {
        if (size == queue.length) {
            System.out.println("⚠ Queue full – cannot add " + data);
            return;
        }
        back = (back + 1) % queue.length;
        queue[back] = new EmployeeCQ(data);
        if (front == -1) front = 0;
        size++;
    }

    public Integer remove() {
        if (size == 0) {
            System.out.println("⚠ Queue empty");
            return null;
        }
        int data = queue[front].data;
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        if (size == 0) { front = -1; back = -1; }  // reset pointers
        return data;
    }

    public int size() { return size; }

    @Override
    public String toString() {
        return "CircularQueue" + Arrays.toString(queue);
    }
}
