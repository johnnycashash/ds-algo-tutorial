package com.ds.algo.designpattern.creational.abstractfactory;

public class AbstractFactoryClient {
    public static void main(String[] args) {
        PrinterAbstractFactory.getPrinter(new LaserPrinterFactory()).print();
        PrinterAbstractFactory.getPrinter(new InkjetPrinterFactory()).print();
    }
}
