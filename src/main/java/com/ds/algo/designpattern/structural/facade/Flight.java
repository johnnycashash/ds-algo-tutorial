package com.ds.algo.designpattern.structural.facade;

public class Flight {
    public void bookFlight(String source, String destination) {
        System.out.println("Flight booked from " + source + " to " + destination);
    }
}
