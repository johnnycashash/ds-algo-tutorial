package com.ds.algo.designpattern.creational.abstractfactory;

import lombok.Data;

@Data
public class InkjetPrinterFactory implements PrinterFactory {
    public Printer getPrinter() {
        return new InkjetPrinter();
    }
}
