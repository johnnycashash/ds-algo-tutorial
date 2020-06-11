package com.ds.algo.designpattern.creational.abstractfactory;

import lombok.Data;

@Data
public class InkjetPrinter implements Printer {
    public void print() {
        System.out.println("Inkjet Printing...");
    }
}
