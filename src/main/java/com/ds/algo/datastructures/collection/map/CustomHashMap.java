package com.ds.algo.datastructures.collection.map;

/**
 * Custom HashMap (interview-classic: "implement your own HashMap").
 *
 * KEY IDEAS:
 *   - Array of buckets, each bucket is a singly linked list (separate chaining).
 *   - Hash the key → bucket index → walk the chain to find/insert.
 *   - Use Math.abs(hashCode) % length to avoid negative index bug.
 *
 * Time : put/get O(1) average, O(n) worst     Space: O(n)
 */
public class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private Entry<K, V>[] buckets;
    private int size = 0;

    public CustomHashMap() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap(int capacity) {
        this.buckets = new Entry[capacity];
    }

    /** Maps key → value.  Overwrites if key already exists. */
    public void put(K key, V value) {
        int idx = bucketIndex(key);
        Entry<K, V> current = buckets[idx];

        // Walk the chain – if key exists, update value
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;          // overwrite
                return;
            }
            current = current.next;
        }
        // Key not found – insert at head of chain
        buckets[idx] = new Entry<>(key, value, buckets[idx]);
        size++;
    }

    /** Returns value for key, or null if absent. */
    public V get(K key) {
        Entry<K, V> current = buckets[bucketIndex(key)];
        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }
        return null;
    }

    /** Removes key and returns its value, or null if absent. */
    public V remove(K key) {
        int idx = bucketIndex(key);
        Entry<K, V> current = buckets[idx], prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) buckets[idx] = current.next;
                else              prev.next = current.next;
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    public int size() { return size; }

    /** Safe bucket index – handles negative hashCode. */
    private int bucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (Entry<K, V> bucket : buckets) {
            Entry<K, V> e = bucket;
            while (e != null) {
                if (!first) sb.append(", ");
                sb.append(e.key).append("=").append(e.value);
                first = false;
                e = e.next;
            }
        }
        return sb.append("}").toString();
    }
}
