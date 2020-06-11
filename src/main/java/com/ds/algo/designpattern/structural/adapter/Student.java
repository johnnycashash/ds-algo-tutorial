package com.ds.algo.designpattern.structural.adapter;

public class Student {
    Pen pen;

    public Student(Pen pen) {
        this.pen = pen;
    }

    public void completeHomeWork() {
        pen.work();
    }
}
