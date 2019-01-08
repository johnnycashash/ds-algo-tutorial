package com.ds.algo.stack.array.withminmax;

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
