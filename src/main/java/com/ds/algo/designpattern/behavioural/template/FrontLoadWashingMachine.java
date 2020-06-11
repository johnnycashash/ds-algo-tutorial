package com.ds.algo.designpattern.behavioural.template;

public class FrontLoadWashingMachine extends WashingMachine {
    protected void addAdvanceCleaningSolution() {
        System.out.println("Adding cleaning solution...");
    }

    protected void takeOutClothes() {
        System.out.println("Takeout clothes from Front...");
    }

    protected void closeDoor() {
        System.out.println("Close Front door...");
    }

    protected void putClothes() {
        System.out.println("Put clothes sideways from Front door...");
    }

    protected void openDoor() {
        System.out.println("Open Front door...");
    }

    @Override
    protected boolean advanceCleaning() {
        return false;
    }
}
