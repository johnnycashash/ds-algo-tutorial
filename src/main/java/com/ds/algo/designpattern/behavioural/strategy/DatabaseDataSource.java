package com.ds.algo.designpattern.behavioural.strategy;

public class DatabaseDataSource implements DataSource {
    public void getData() {
        System.out.println("Getting Data from db");
    }
}
