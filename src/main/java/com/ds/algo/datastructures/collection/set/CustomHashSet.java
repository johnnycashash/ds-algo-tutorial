package com.ds.algo.datastructures.collection.set;

import lombok.ToString;

import java.util.HashMap;

@ToString
public class CustomHashSet {
    private static final Object dummyObject = new Object();
    private HashMap<Object, Object> hashMapReference = null;

    public CustomHashSet() {
        hashMapReference = new HashMap<>();
    }

    public boolean add(Object object) {
        return hashMapReference.put(object, dummyObject) == null;
    }

}
