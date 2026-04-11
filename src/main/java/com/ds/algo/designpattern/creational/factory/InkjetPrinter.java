package com.ds.algo.designpattern.creational.factory;

public class InkjetPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Inkjet Printing...");
    }
}
