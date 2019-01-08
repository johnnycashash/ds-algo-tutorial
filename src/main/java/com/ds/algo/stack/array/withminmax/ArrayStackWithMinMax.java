package com.ds.algo.stack.array.withminmax;

public class ArrayStackWithMinMax {
    MinMaxData[] stack;
    int top;

    public ArrayStackWithMinMax(int capacity) {
        stack = new MinMaxData[capacity];
    }

    public void push(int data) {
        if (top == stack.length) {
            System.out.println("resize or exception");
            return;
        }
        MinMaxData toBeInserted = null;
        if (top == 0) {
            toBeInserted = new MinMaxData(data, data, data);
        } else {
            MinMaxData prevMinMaxData = stack[top - 1];
            toBeInserted = new MinMaxData(data, prevMinMaxData.getMin(), prevMinMaxData.getMax());
            if (data < prevMinMaxData.getMin()) {
                toBeInserted.setMin(data);
            }
            if (data > prevMinMaxData.getMax()) {
                toBeInserted.setMax(data);
            }
        }
        stack[top++] = toBeInserted;
    }

    public int pop() {
        if (top == 0) {
            System.out.println("exception");
            return -1;
        }
        MinMaxData minMaxData = stack[--top];
        stack[top] = null;
        return minMaxData.getData();
    }

    public int peek() {
        //if top!=0
        return stack[top - 1].getData();
    }

    public int getMin() {
        //if top!=0
        return stack[top - 1].getMin();
    }

    public int getMax() {
        //if top!=0
        return stack[top - 1].getMax();
    }
}

