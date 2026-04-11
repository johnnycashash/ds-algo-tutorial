package com.ds.algo.datastructures.stack.array;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Array-backed Stack (interview-classic: "implement Stack using an array").
 *
 * KEY IDEA: Use a 'top' pointer. Push increments it, pop decrements it.
 *           When full, double the backing array (amortised O(1)).
 *
 * Time : push O(1) amortised, pop O(1), peek O(1)
 * Space: O(n)
 *
 * LIFO – Last In, First Out.
 */
public class ArrayStack {
    private Object[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = new Object[capacity];
    }

    public void push(Object item) {
        if (top == stack.length) grow();
        stack[top++] = item;
    }

    public Object pop() {
        if (isEmpty()) throw new EmptyStackException();
        Object item = stack[--top];
        stack[top] = null;              // help GC
        return item;
    }

    public Object peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top - 1];
    }

    public boolean isEmpty() { return top == 0; }
    public int size()        { return top; }

    private void grow() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println("  " + stack[i]);
        }
    }
}
