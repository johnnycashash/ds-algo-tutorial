package com.ds.algo.designpattern.creational.abstractfactory;

import lombok.Data;

@Data
public class LaserPrinterFactory implements PrinterFactory {

    public Printer getPrinter() {
        return new LaserPrinter();
    }
}
