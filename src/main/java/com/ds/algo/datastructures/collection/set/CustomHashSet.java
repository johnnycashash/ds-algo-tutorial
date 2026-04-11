package com.ds.algo.datastructures.collection.set;

import java.util.HashMap;

/**
 * Custom HashSet (interview-classic: "implement your own HashSet").
 *
 * KEY IDEA: A HashSet is just a HashMap where every key maps to a DUMMY value.
 *           This is exactly how java.util.HashSet is implemented internally.
 *
 * Time : add/contains/remove O(1) average     Space: O(n)
 */
public class CustomHashSet<E> {
    private static final Object PRESENT = new Object();   // dummy value
    private final HashMap<E, Object> map;

    public CustomHashSet() {
        map = new HashMap<>();
    }

    /** Returns true if element was actually added (not a duplicate). */
    public boolean add(E element) {
        return map.put(element, PRESENT) == null;
    }

    public boolean contains(E element) {
        return map.containsKey(element);
    }

    public boolean remove(E element) {
        return map.remove(element) != null;
    }

    public int size() {
        return map.size();
    }

    @Override
    public String toString() {
        return map.keySet().toString();
    }
}
