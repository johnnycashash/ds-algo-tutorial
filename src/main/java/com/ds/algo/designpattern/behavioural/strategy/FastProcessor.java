package com.ds.algo.designpattern.behavioural.strategy;

public class FastProcessor implements Processor {
    public void processData() {
        System.out.println("Doing async and batch operation on data");
    }
}
