package com.ds.algo.designpattern.behavioural.pubsub;

/**
 * Demo: Pub/Sub pattern.
 * Publisher and Subscriber are fully decoupled via EventBus.
 */
public class PubSubDemo {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        // Subscribers register for topics
        eventBus.subscribe("orders", new EmailService());
        eventBus.subscribe("orders", new AnalyticsService());

        // Publisher publishes to topics (doesn't know who subscribes)
        Publisher publisher = new Publisher(eventBus);
        publisher.publishEvent("orders", "Order #101 Created!");
        publisher.publishEvent("orders", "Order #102 Shipped!");
    }
}
