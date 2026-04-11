package com.ds.algo.designpattern.creational.abstractfactory;

/**
 * Abstract Factory Pattern – factory of factories.
 *
 * KEY IDEA: Instead of passing a string to decide which product to create,
 *           pass a FACTORY OBJECT. Each factory knows how to create its family of products.
 *
 *   PrinterAbstractFactory.getPrinter(new LaserPrinterFactory())  → LaserPrinter
 *   PrinterAbstractFactory.getPrinter(new InkjetPrinterFactory()) → InkjetPrinter
 */
public class PrinterAbstractFactory {
    public static Printer getPrinter(PrinterFactory factory) {
        return factory.getPrinter();
    }
}
