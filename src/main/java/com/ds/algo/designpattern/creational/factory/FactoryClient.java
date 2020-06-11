package com.ds.algo.designpattern.creational.factory;

public class FactoryClient {
    public static void main(String[] args) {
        PrinterFactory.getPrinter("laser").print();
        PrinterFactory.getPrinter("inkjet").print();
    }
}
