package com.ds.algo.designpattern.behavioural.strategy;

public class Operation {
    DataSource dataSource;
    Processor processor;
    DataSink dataSink;

    public Operation(DataSource dataSource, Processor processor, DataSink dataSink) {
        this.dataSource = dataSource;
        this.processor = processor;
        this.dataSink = dataSink;
    }

    public void operate() {
        dataSource.getData();
        processor.processData();
        dataSink.dumpData();
    }
}
