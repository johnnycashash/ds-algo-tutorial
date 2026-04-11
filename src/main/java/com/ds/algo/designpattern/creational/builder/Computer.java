package com.ds.algo.designpattern.creational.builder;

/**
 * Builder Pattern – construct complex objects step-by-step.
 *
 * KEY IDEA: When a class has many optional parameters, use a static inner Builder
 *           to avoid telescoping constructors.
 *
 * Benefits:
 *   - Immutable objects (no setters on Computer).
 *   - Readable fluent API: new Computer.Builder(16, 512).setGraphics(true).build()
 */
public class Computer {
    private final int ram;          // required
    private final int hdd;          // required
    private final boolean graphics; // optional

    private Computer(Builder builder) {
        this.ram = builder.ram;
        this.hdd = builder.hdd;
        this.graphics = builder.graphics;
    }

    public int getRam()          { return ram; }
    public int getHdd()          { return hdd; }
    public boolean hasGraphics() { return graphics; }

    @Override
    public String toString() {
        return "Computer{ram=" + ram + "GB, hdd=" + hdd + "GB, graphics=" + graphics + "}";
    }

    // ── Static inner Builder ──
    public static class Builder {
        private final int ram;
        private final int hdd;
        private boolean graphics;

        public Builder(int ram, int hdd) {
            this.ram = ram;
            this.hdd = hdd;
        }

        public Builder setGraphics(boolean graphics) {
            this.graphics = graphics;
            return this;                // fluent API
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
