package com.ds.algo.datastructures.collection.map;

/**
 * Node in the HashMap's bucket chain (singly linked list).
 */
class Entry<K, V> {
    final K key;
    V value;
    Entry<K, V> next;

    Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
