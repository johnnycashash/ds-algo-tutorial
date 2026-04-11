package com.ds.algo.datastructures.queue.array;

/** Demo: Circular Array Queue with auto-resize. */
public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(3);
        q.enqueue("Alice");
        q.enqueue("Bob");
        q.enqueue("Charlie");
        System.out.println("Size    : " + q.size());       // 3
        q.enqueue("Diana");                                  // triggers resize
        System.out.println("Size    : " + q.size());       // 4
        System.out.println("Dequeue : " + q.dequeue());    // Alice
        System.out.println("Peek    : " + q.peek());       // Bob
    }
}
