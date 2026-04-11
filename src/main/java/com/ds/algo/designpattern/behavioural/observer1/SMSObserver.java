package com.ds.algo.designpattern.behavioural.observer1;

public class SMSObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("[SMSObserver] SMS received: " + message);
    }
}
