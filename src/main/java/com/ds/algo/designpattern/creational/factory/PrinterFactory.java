package com.ds.algo.designpattern.creational.factory;

public class PrinterFactory {
    public static Printer getPrinter(String type) {
        if (type.equals("laser")) {
            return new LaserPrinter();
        } else if (type.equals("inkjet")) {
            return new InkjetPrinter();
        } else {
            throw new RuntimeException("No such Printer Available");
        }
    }
}
