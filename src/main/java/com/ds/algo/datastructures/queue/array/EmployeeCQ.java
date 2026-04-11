package com.ds.algo.datastructures.queue.array;

/**
 * Simple data wrapper for circular queue demo.
 */
public class EmployeeCQ {
    final Integer data;

    public EmployeeCQ(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
