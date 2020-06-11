package com.ds.algo.datastructures.collection.set;

public class SetClient {
    public static void main(String[] args) {
        CustomHashSet hashSetObj = new CustomHashSet();
        hashSetObj.add("jag");
        hashSetObj.add("an");
        hashSetObj.add("sin");
        hashSetObj.add("jag");
        System.out.println(hashSetObj);

    }
}
