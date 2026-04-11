package com.ds.algo.datastructures.stack.array;

/** Demo: Array-backed Stack. */
public class TestArrayStack {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push("Alice");
        stack.push("Bob");
        stack.push("Charlie");
        stack.push("Diana");        // triggers grow (3 → 6)

        System.out.println("Size : " + stack.size());   // 4
        System.out.println("Peek : " + stack.peek());   // Diana
        System.out.println("Pop  : " + stack.pop());    // Diana
        System.out.println("Pop  : " + stack.pop());    // Charlie
        System.out.println("Peek : " + stack.peek());   // Bob

        System.out.println("\n── Remaining stack (top → bottom) ──");
        stack.printStack();
    }
}
