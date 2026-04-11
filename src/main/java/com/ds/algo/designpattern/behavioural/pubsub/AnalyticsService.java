package com.ds.algo.designpattern.behavioural.pubsub;

public class AnalyticsService implements Subscriber {
    @Override
    public void onMessage(String message) {
        System.out.println("[AnalyticsService] " + message);
    }
}
