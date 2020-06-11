package com.ds.algo.designpattern.structural.adapter;

public class AdapterClient {
    public static void main(String[] args) {


        Pen pen = new GelPen();
        Student student = new Student(pen);
        student.completeHomeWork();

        Pen pencil = new PencilAdapter(new Pencil());
        Student student1 = new Student(pencil);
        student1.completeHomeWork();
    }
}
