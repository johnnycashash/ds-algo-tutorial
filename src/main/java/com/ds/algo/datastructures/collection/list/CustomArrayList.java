package com.ds.algo.datastructures.collection.list;

import java.util.Arrays;

/**
 * Custom ArrayList (interview-classic: "implement your own ArrayList").
 *
 * KEY IDEAS:
 *   - Backed by Object[] with a default capacity of 10.
 *   - When full, double the capacity (amortised O(1) add).
 *   - add(), get(), remove(), size() operations.
 *
 * Time : add O(1) amortised, get O(1), remove O(n)
 * Space: O(n)
 */
public class CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /** Append element at the end. */
    public void add(E e) {
        if (size == elements.length) grow();
        elements[size++] = e;
    }

    /** Get element at index. */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return (E) elements[index];
    }

    /** Remove element at index and shift remaining left. */
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        E removed = (E) elements[index];
        int numToMove = size - index - 1;
        if (numToMove > 0)
            System.arraycopy(elements, index + 1, elements, index, numToMove);
        elements[--size] = null;    // help GC
        return removed;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    /** Double the backing array when full. */
    private void grow() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(elements[i]);
        }
        return sb.append("]").toString();
    }
}