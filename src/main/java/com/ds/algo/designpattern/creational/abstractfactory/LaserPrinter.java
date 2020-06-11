package com.ds.algo.designpattern.creational.abstractfactory;

import lombok.Data;

@Data
public class LaserPrinter implements Printer {
    public void print() {
        System.out.println("Laser Printing...");
    }
}
