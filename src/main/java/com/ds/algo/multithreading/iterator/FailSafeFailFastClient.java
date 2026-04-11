package com.ds.algo.multithreading.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Fail-Fast vs Fail-Safe Iterators.
 *
 * FAIL-FAST (ArrayList, HashMap):
 *   Throws ConcurrentModificationException if collection is modified during iteration.
 *   Uses internal modCount to detect changes.
 *   FIX: Use iterator.remove() instead of collection.remove().
 *
 * FAIL-SAFE (CopyOnWriteArrayList, ConcurrentHashMap):
 *   Works on a COPY/snapshot of the collection.
 *   No exception, but may not see latest changes.
 */
public class FailSafeFailFastClient {

    public static void main(String[] args) {

        // ─── FAIL-FAST demo (use iterator.remove() to avoid CME) ───
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int val = it.next();
            if (val % 2 == 0) {
                it.remove();    // ✅ Safe way to remove during iteration
            }
        }
        System.out.println("After fail-fast remove evens: " + list);  // [1, 3, 5]

        // ─── FAIL-SAFE demo ───
        List<Integer> safeList = new CopyOnWriteArrayList<>(List.of(10, 20, 30));
        for (Integer val : safeList) {
            safeList.add(99);          // No exception! Iterates over snapshot.
        }
        System.out.println("After fail-safe additions   : " + safeList);
        // [10, 20, 30, 99, 99, 99]
    }
}
