package com.ds.algo.designpattern.creational.prototype;

import java.util.ArrayList;

public class PrototypeClient {
    public static void main(String[] args) throws CloneNotSupportedException {
        Order order = new Order();
        order.setOrderId(1);
        ArrayList<LineItem> lineItems = new ArrayList<LineItem>();
        lineItems.add(new LineItem("MotherDairy Ghee", 2));
        lineItems.add(new LineItem("Lux Soap M", 4));
        order.setLineItems(lineItems);

        Order orderClone = order.clone();

        System.out.println(order);
        System.out.println(orderClone);
        System.out.println("Its a clone " + (order != orderClone));
    }

}
