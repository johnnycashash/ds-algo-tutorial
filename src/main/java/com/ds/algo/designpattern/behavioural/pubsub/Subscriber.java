package com.ds.algo.designpattern.behavioural.pubsub;

/**
 * Subscriber interface for Pub/Sub pattern.
 */
public interface Subscriber {
    void onMessage(String message);
}
