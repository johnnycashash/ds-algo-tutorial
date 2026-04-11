package com.ds.algo.designpattern.creational.prototype;

/**
 * Line item in an Order (used to demonstrate deep cloning).
 */
public class LineItem implements Cloneable {
    private String productName;
    private int quantity;

    public LineItem(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() { return productName; }
    public int getQuantity()       { return quantity; }

    @Override
    protected LineItem clone() throws CloneNotSupportedException {
        return (LineItem) super.clone();    // shallow clone is fine (only primitives + String)
    }

    @Override
    public String toString() {
        return productName + " x" + quantity;
    }
}
