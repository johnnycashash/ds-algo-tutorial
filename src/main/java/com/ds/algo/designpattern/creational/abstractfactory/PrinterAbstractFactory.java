package com.ds.algo.designpattern.creational.abstractfactory;

public class PrinterAbstractFactory {
    public static Printer getPrinter(PrinterFactory printerFactory) {
        return printerFactory.getPrinter();

    }
}
