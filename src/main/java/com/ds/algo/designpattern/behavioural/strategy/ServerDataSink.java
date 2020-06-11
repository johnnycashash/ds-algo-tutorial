package com.ds.algo.designpattern.behavioural.strategy;

public class ServerDataSink implements DataSink {
    public void dumpData() {
        System.out.println("Dumping data to server on TCP connection");
    }
}
