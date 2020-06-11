package com.ds.algo.designpattern.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LineItem implements Cloneable {
    private String productName;
    private int quantity;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
