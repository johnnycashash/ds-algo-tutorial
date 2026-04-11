package com.ds.algo.datastructures.hashtable;

/**
 * Simplest Hash Table – array-based, NO collision handling.
 *
 * PURPOSE: Understand hashing basics before learning chaining / open addressing.
 *
 * KEY IDEA: hash(key) → index → store value at that index.
 *           If two keys hash to the same index → collision (not handled here).
 *
 * Time : put/get O(1)    Space: O(capacity)
 */
public class SimpleHashTable {
    private String[] keys;
    private String[] values;
    private int capacity;

    public SimpleHashTable(int capacity) {
        this.capacity = capacity;
        keys = new String[capacity];
        values = new String[capacity];
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(String key, String value) {
        int idx = hash(key);
        if (keys[idx] != null && !keys[idx].equals(key)) {
            System.out.println("⚠ Collision at index " + idx + " – cannot store '" + key + "'");
            return;
        }
        keys[idx] = key;
        values[idx] = value;
    }

    public String get(String key) {
        int idx = hash(key);
        if (keys[idx] != null && keys[idx].equals(key)) return values[idx];
        return null;
    }

    // ──────────── demo ────────────
    public static void main(String[] args) {
        SimpleHashTable ht = new SimpleHashTable(10);
        ht.put("Alice", "Engineer");
        ht.put("Bob", "Designer");
        System.out.println("Alice → " + ht.get("Alice"));   // Engineer
        System.out.println("Bob   → " + ht.get("Bob"));     // Designer
        System.out.println("Eve   → " + ht.get("Eve"));     // null
    }
}
