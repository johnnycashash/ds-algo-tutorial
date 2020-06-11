package com.ds.algo.datastructures.collection.list;

public class ArraylistClient {
    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        System.out.println(list.get(4));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }
}
