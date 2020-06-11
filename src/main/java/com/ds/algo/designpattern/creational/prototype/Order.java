package com.ds.algo.designpattern.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Cloneable {
    private int orderId;
    private List<LineItem> lineItems;

    //Need Deep Cloning
    @Override
    protected Order clone() throws CloneNotSupportedException {
        List<LineItem> lineItems = new ArrayList<LineItem>();
        for (LineItem lineItem : this.lineItems) {
            lineItems.add((LineItem) lineItem.clone());
        }
        return new Order(this.orderId, lineItems);
    }
}
