package com.ds.algo.designpattern.behavioural.observer1;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject (Observable) – maintains a list of observers and notifies them.
 *
 * Observer Pattern:
 *   Subject ──notify──► Observer1
 *                     ► Observer2
 *
 * The subject knows its observers directly (tight coupling to Observer interface,
 * but loose coupling to concrete implementations).
 */
public class Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer)  { observers.add(observer); }
    public void detach(Observer observer)  { observers.remove(observer); }

    public void setState(String state) {
        System.out.println("[Subject] State changed to: " + state);
        notifyAllObservers(state);
    }

    private void notifyAllObservers(String state) {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}
