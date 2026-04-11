package com.ds.algo.designpattern.creational.abstractfactory;

public class InkjetPrinterFactory implements PrinterFactory {
    @Override
    public Printer getPrinter() { return new InkjetPrinter(); }
}
