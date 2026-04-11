package com.ds.algo.datastructures.queue.array;

import java.util.NoSuchElementException;

/**
 * Circular Array Queue (interview-classic).
 *
 * KEY IDEA: Use front/back pointers that wrap around using modulo.
 *           This avoids wasting space at the front after dequeue.
 *
 * Time : enqueue/dequeue/peek O(1)    Space: O(capacity)
 *
 * FIFO – First In, First Out.
 */
public class ArrayQueue {
    private Object[] queue;
    private int front;
    private int back;
    private int size;

    public ArrayQueue(int capacity) {
        queue = new Object[capacity];
    }

    /** Add to the back of the queue. */
    public void enqueue(Object item) {
        if (size == queue.length) {
            // Double capacity and unwrap circular buffer
            Object[] newQueue = new Object[queue.length * 2];
            for (int i = 0; i < size; i++) {
                newQueue[i] = queue[(front + i) % queue.length];
            }
            queue = newQueue;
            front = 0;
            back = size;
        }
        queue[back] = item;
        back = (back + 1) % queue.length;      // wrap around
        size++;
    }

    /** Remove from the front of the queue. */
    public Object dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        Object item = queue[front];
        queue[front] = null;                    // help GC
        front = (front + 1) % queue.length;     // wrap around
        size--;
        return item;
    }

    public Object peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return queue[front];
    }

    public int size()        { return size; }
    public boolean isEmpty() { return size == 0; }

    public void printQueue() {
        for (int i = 0; i < size; i++) {
            System.out.println("  " + queue[(front + i) % queue.length]);
        }
    }

    // ──────────── demo ────────────
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(3);
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        System.out.println("Dequeue: " + q.dequeue());  // A
        q.enqueue("D");
        q.enqueue("E");  // triggers resize

        System.out.println("Peek   : " + q.peek());     // B
        System.out.println("Size   : " + q.size());     // 4
        System.out.println("\n── Queue (front → back) ──");
        q.printQueue();
    }
}
