package com.ds.algo.designpattern.behavioural.template;

public abstract class WashingMachine {
    public final void washClothes() {
        this.switchOn();
        this.openDoor();
        this.putClothes();
        this.putPowder();
        if (advanceCleaning()) {//hook: Can be overridden
            this.addAdvanceCleaningSolution();
        }
        this.closeDoor();
        this.setOperation();
        this.switchOff();
        this.openDoor();
        this.takeOutClothes();
        this.closeDoor();
    }

    protected boolean advanceCleaning() {
        return true;
    }

    protected abstract void addAdvanceCleaningSolution();

    protected abstract void takeOutClothes();

    protected void switchOff() {
        System.out.println("Switching off...");
    }

    protected void setOperation() {
        System.out.println("Setting operation...");
    }

    protected abstract void closeDoor();

    protected void putPowder() {
        System.out.println("Putting Powder...");
    }

    protected abstract void putClothes();

    protected abstract void openDoor();

    protected void switchOn() {
        System.out.println("Switching on...");
    }
}
