package com.ds.algo.datastructures.hashtable;

import com.ds.algo.datastructures.queue.array.Employee;

public class SimpleHashTable {
    Employee[] hashtable;

    public SimpleHashTable(int capacity) {
        hashtable = new Employee[capacity];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void add(String key, Employee employee) {
        int hashKey = hashKey(key);
        if (hashtable[hashKey] != null) {
            System.out.println("Sorry cannt handle collision");
        } else {
            hashtable[hashKey] = employee;
        }
    }

    public Employee get(String key) {
        return hashtable[hashKey(key)];
    }
}
