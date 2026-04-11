package com.ds.algo.designpattern.behavioural.pubsub;

/** Publisher sends messages to topics via the EventBus. */
public class Publisher {
    private final EventBus eventBus;

    public Publisher(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void publishEvent(String topic, String message) {
        eventBus.publish(topic, message);
    }
}
