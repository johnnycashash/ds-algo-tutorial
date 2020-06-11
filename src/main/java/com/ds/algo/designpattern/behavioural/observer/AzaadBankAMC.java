package com.ds.algo.designpattern.behavioural.observer;

public class AzaadBankAMC implements Observer {
    private Observable stockMarket;
    private float marketValue;

    public AzaadBankAMC(Observable stockMarket) {
        this.stockMarket = stockMarket;
        stockMarket.registerObserver(this);
    }

    public void update(float marketValue) {
        this.marketValue = marketValue;
        updateCustomers();
    }

    private void updateCustomers() {
        System.out.println("Azaad Bank: Market value has been changed, Current value: " + marketValue);
    }
}
