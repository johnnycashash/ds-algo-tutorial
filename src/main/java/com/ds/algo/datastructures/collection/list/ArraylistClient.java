package com.ds.algo.datastructures.collection.list;

/** Demo: Custom ArrayList operations. */
public class ArraylistClient {
    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("Full list : " + list);          // [10, 20, 30, 40, 50]
        System.out.println("get(2)    : " + list.get(2));    // 30
        System.out.println("size()    : " + list.size());    // 5

        System.out.println("remove(1) : " + list.remove(1)); // 20
        System.out.println("After rem : " + list);           // [10, 30, 40, 50]
    }
}
