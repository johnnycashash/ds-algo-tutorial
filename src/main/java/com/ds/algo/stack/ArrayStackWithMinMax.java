package com.ds.algo.stack;

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
        MinMaxData toBeInserted = new MinMaxData(data, data, data);
        toBeInserted.setData(data);
        MinMaxData prevMinMaxData = stack[top - 1];
        if (data <= prevMinMaxData.getMin()) {
            toBeInserted.setMin(data);
        }
        if (data >= prevMinMaxData.getMax()) {
            toBeInserted.setMax(data);
        }
        stack[top++] = toBeInserted;
    }
    public int pop() {
        if (top == 0) {
            System.out.println("exception");
            return -1;
        }
        MinMaxData minMaxData = stack[--top];
        stack[top]=null;
        return minMaxData.getData();
    }
    public int peek(){
        //if top!=0
        return stack[top-1].getData();
    }
    public int getMin(){
        //if top!=0
        return stack[top-1].getMin();
    }
    public int getMax(){
        //if top!=0
        return stack[top-1].getMax();
    }
}

class MinMaxData {
    int data;
    int min;
    int max;

    public MinMaxData(int data, int min, int max) {
        this.data = data;
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
