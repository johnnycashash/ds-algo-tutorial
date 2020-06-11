package com.ds.algo.designpattern.behavioural.template;

public class TopLoadWashingMachine extends WashingMachine {
    protected void addAdvanceCleaningSolution() {
        System.out.println("Adding cleaning solution...");
    }

    protected void takeOutClothes() {
        System.out.println("Takeout clothes from top...");
    }

    protected void closeDoor() {
        System.out.println("Close Top door...");
    }

    protected void putClothes() {
        System.out.println("Drop down clothes from Top door...");
    }

    protected void openDoor() {
        System.out.println("Open Top door...");
    }
}
