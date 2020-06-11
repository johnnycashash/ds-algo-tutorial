package com.ds.algo.designpattern.behavioural.strategy;

public class StrategyClient {
    public static void main(String[] args) {
        Operation operation = new Operation(new DatabaseDataSource(), new FastProcessor(), new ServerDataSink());
        operation.operate();
    }
}
