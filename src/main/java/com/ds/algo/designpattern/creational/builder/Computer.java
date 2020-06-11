package com.ds.algo.designpattern.creational.builder;

import lombok.Value;

@Value
public class Computer {
    int ram;
    int hdd;
    boolean graphics;

    private Computer(Builder builder) {
        this.ram = builder.ram;
        this.hdd = builder.hdd;
        this.graphics = builder.graphics;
    }

    public static class Builder {
        private final int ram;
        private final int hdd;
        boolean graphics;

        public Builder(int ram, int hdd) {
            this.ram = ram;
            this.hdd = hdd;
        }

        Builder setGraphics(boolean graphics) {
            this.graphics = graphics;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
