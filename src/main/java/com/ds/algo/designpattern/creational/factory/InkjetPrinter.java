package com.ds.algo.designpattern.creational.factory;

import lombok.Data;

@Data
public class InkjetPrinter implements Printer {
    public void print() {
        System.out.println("Inkjet Printing...");
    }
}
