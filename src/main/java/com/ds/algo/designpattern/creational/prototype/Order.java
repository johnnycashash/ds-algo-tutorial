package com.ds.algo.designpattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Prototype Pattern – create new objects by CLONING an existing prototype.
 *
 * KEY IDEA: When object creation is expensive, clone an existing object instead.
 *
 * DEEP vs SHALLOW clone:
 *   Shallow → copies references (both point to same inner objects)
 *   Deep    → copies the inner objects too (independent copies)
 *
 * Order contains a List<LineItem> → we need DEEP cloning.
 */
public class Order implements Cloneable {
    private int orderId;
    private List<LineItem> lineItems;

    public Order() {}

    public Order(int orderId, List<LineItem> lineItems) {
        this.orderId = orderId;
        this.lineItems = lineItems;
    }

    public int getOrderId()             { return orderId; }
    public void setOrderId(int id)      { this.orderId = id; }
    public List<LineItem> getLineItems() { return lineItems; }
    public void setLineItems(List<LineItem> items) { this.lineItems = items; }

    /** Deep clone – each LineItem is cloned independently. */
    @Override
    protected Order clone() throws CloneNotSupportedException {
        List<LineItem> clonedItems = new ArrayList<>();
        for (LineItem item : this.lineItems) {
            clonedItems.add(item.clone());
        }
        return new Order(this.orderId, clonedItems);
    }

    @Override
    public String toString() {
        return "Order{id=" + orderId + ", items=" + lineItems + "}";
    }
}
