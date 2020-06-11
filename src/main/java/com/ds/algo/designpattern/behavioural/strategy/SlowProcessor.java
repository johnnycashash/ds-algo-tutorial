package com.ds.algo.designpattern.behavioural.strategy;

public class SlowProcessor implements Processor {
    public void processData() {
        System.out.println("Doing synchronous operation on data");
    }
}
