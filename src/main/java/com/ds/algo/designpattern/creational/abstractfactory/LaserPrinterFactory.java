package com.ds.algo.designpattern.creational.abstractfactory;

public class LaserPrinterFactory implements PrinterFactory {
    @Override
    public Printer getPrinter() { return new LaserPrinter(); }
}
