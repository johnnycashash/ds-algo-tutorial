package com.ds.algo.designpattern.behavioural.observer;

public class ObserverClient {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        AzaadBankAMC azaadBankAMC = new AzaadBankAMC(stockMarket);
        FraudBankAMC fraudBankAMC = new FraudBankAMC(stockMarket);
        stockMarket.setMarketValue(28000);
        stockMarket.removeObserver(fraudBankAMC);
        stockMarket.setMarketValue(120444);
    }
}
