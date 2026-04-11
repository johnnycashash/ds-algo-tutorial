package com.ds.algo.datastructures.stack.array.withminmax;

/**
 * Stack that supports getMin() and getMax() in O(1).
 *
 * KEY IDEA: Each slot stores {data, currentMin, currentMax}.
 *           When pushing, compare with the previous top's min/max.
 *           When popping, the min/max is automatically restored.
 *
 * Time : push/pop/getMin/getMax all O(1)
 * Space: O(n) – 3 ints per element
 */
public class ArrayStackWithMinMax {
    private int[] data;
    private int[] mins;
    private int[] maxs;
    private int top = -1;

    public ArrayStackWithMinMax(int capacity) {
        data = new int[capacity];
        mins = new int[capacity];
        maxs = new int[capacity];
    }

    public void push(int val) {
        if (top + 1 == data.length) throw new RuntimeException("Stack full");
        top++;
        data[top] = val;
        mins[top] = (top == 0) ? val : Math.min(val, mins[top - 1]);
        maxs[top] = (top == 0) ? val : Math.max(val, maxs[top - 1]);
    }

    public int pop() {
        if (top < 0) throw new RuntimeException("Stack empty");
        return data[top--];
    }

    public int peek()   { return data[top]; }
    public int getMin() { return mins[top]; }
    public int getMax() { return maxs[top]; }
    public boolean isEmpty() { return top < 0; }

    // ──────────── demo ────────────
    public static void main(String[] args) {
        ArrayStackWithMinMax s = new ArrayStackWithMinMax(10);
        s.push(4);
        s.push(6);
        s.push(2);
        System.out.println("Min: " + s.getMin());  // 2
        System.out.println("Max: " + s.getMax());  // 6

        s.pop();  // remove 2
        System.out.println("Min after pop: " + s.getMin());  // 4
        System.out.println("Max after pop: " + s.getMax());  // 6
    }
}
