package com.ds.algo.designpattern.behavioural.strategy;

public class LocalDataSink implements DataSink {
    public void dumpData() {
        System.out.println("Dumping data to local file");
    }
}
