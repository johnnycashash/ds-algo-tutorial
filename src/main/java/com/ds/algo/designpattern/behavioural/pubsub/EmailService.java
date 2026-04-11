package com.ds.algo.designpattern.behavioural.pubsub;

public class EmailService implements Subscriber {
    @Override
    public void onMessage(String message) {
        System.out.println("[EmailService] " + message);
    }
}
