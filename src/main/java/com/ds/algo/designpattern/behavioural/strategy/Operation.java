package com.ds.algo.designpattern.behavioural.strategy;

/**
 * Strategy Pattern – Context (Operation) delegates work to swappable strategy interfaces.
 *
 * KEY IDEA: Define a family of algorithms, encapsulate each one, and make them interchangeable.
 *           The client decides WHICH concrete strategy to inject.
 *
 *   Operation uses: DataSource (strategy), Processor (strategy), DataSink (strategy)
 *   → Any combination can be plugged in at runtime.
 */
public class Operation {
    private final DataSource dataSource;
    private final Processor processor;
    private final DataSink dataSink;

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
