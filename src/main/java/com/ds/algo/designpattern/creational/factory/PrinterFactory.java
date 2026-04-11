package com.ds.algo.designpattern.creational.factory;

/**
 * Factory Pattern – delegate object creation to a factory method.
 *
 * KEY IDEA: Client says WHAT it wants (e.g. "laser"), factory decides HOW to create it.
 *           Client code depends on the Printer interface, NOT on concrete classes.
 */
public class PrinterFactory {
    public static Printer getPrinter(String type) {
        switch (type.toLowerCase()) {
            case "laser":  return new LaserPrinter();
            case "inkjet": return new InkjetPrinter();
            default: throw new IllegalArgumentException("Unknown printer type: " + type);
        }
    }
}
