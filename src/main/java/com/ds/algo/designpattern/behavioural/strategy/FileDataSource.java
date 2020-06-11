package com.ds.algo.designpattern.behavioural.strategy;

public class FileDataSource implements DataSource {
    public void getData() {
        System.out.println("Getting Data from file");
    }
}
