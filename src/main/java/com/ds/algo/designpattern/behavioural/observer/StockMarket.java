package com.ds.algo.designpattern.behavioural.observer;

import java.util.Vector;

public class StockMarket implements Observable {
    private Vector<Observer> observers;
    private float marketValue;

    public StockMarket() {
        this.observers = new Vector<Observer>();
    }

    public synchronized void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public synchronized void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer :
                observers) {
            observer.update(marketValue);
        }
    }

    public void changeInMarketValue() {
        notifyObservers();
    }

    public void setMarketValue(float marketValue) {
        this.marketValue = marketValue;
        changeInMarketValue();
    }
}
