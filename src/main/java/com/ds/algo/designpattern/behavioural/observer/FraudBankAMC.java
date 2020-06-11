package com.ds.algo.designpattern.behavioural.observer;

public class FraudBankAMC implements Observer {
    private Observable stockMarket;
    private float marketValue;

    public FraudBankAMC(Observable stockMarket) {
        this.stockMarket = stockMarket;
        stockMarket.registerObserver(this);
    }

    public void update(float marketValue) {
        this.marketValue = marketValue;
        updateCustomers();
    }

    private void updateCustomers() {
        System.out.println("Fraud Bank: Market value has been changed, Current value: " + marketValue / 2);
    }
}
