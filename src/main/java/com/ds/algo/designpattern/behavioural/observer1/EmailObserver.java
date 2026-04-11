package com.ds.algo.designpattern.behavioural.observer1;

public class EmailObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("[EmailObserver] Email received: " + message);
    }
}
