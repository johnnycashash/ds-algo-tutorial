package com.ds.algo.designpattern.behavioural.pubsub;

import java.util.*;

/**
 * EventBus – the middleman in Pub/Sub pattern.
 *
 * KEY DIFFERENCE from Observer:
 *   Observer:  Subject knows its observers directly.
 *   Pub/Sub:   Publisher → EventBus → Subscribers.  Publisher & Subscriber are decoupled.
 *
 * Subscribers subscribe to TOPICS. Publishers publish to TOPICS.
 */
public class EventBus {
    private final Map<String, List<Subscriber>> topics = new HashMap<>();

    public void subscribe(String topic, Subscriber subscriber) {
        topics.computeIfAbsent(topic, k -> new ArrayList<>()).add(subscriber);
    }

    public void publish(String topic, String message) {
        List<Subscriber> subs = topics.getOrDefault(topic, Collections.emptyList());
        for (Subscriber sub : subs) {
            sub.onMessage(message);
        }
    }
}
