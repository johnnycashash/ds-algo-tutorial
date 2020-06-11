package com.ds.algo.designpattern.behavioural.template;

public class TemplateClient {
    public static void main(String[] args) {
        WashingMachine washingMachine = new FrontLoadWashingMachine();
        washingMachine.washClothes();
        System.out.println("---------------------------------------------");
        washingMachine = new TopLoadWashingMachine();
        washingMachine.washClothes();
    }
}
