package com.ds.algo.designpattern.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Observable – StockMarket notifies all registered observers
 * whenever the market value changes.
 */
public class StockMarket implements Observable {
    private final List<Observer> observers = new ArrayList<>();
    private float marketValue;

    @Override
    public void registerObserver(Observer observer) { observers.add(observer); }

    @Override
    public void removeObserver(Observer observer) { observers.remove(observer); }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(marketValue);
        }
    }

    public void setMarketValue(float marketValue) {
        this.marketValue = marketValue;
        System.out.println("\n[StockMarket] Value changed to: " + marketValue);
        notifyObservers();
    }
}
