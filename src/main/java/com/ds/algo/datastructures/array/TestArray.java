package com.ds.algo.datastructures.array;

import java.util.Arrays;

/**
 * Array Basics – quick refresher for interviews.
 *
 * KEY POINTS:
 *   - Fixed size, contiguous memory, O(1) random access.
 *   - Insert/delete at arbitrary index → O(n) due to shifting.
 *   - Java arrays are zero-indexed; .length gives the capacity.
 */
public class TestArray {
    public static void main(String[] args) {
        // Declaration & initialisation
        int[] arr = {20, -1, 20, 45, 2, 7, 222};

        System.out.println("Length  : " + arr.length);                // 7
        System.out.println("Element : " + arr[3]);                    // 45
        System.out.println("Array   : " + Arrays.toString(arr));

        // Sort
        Arrays.sort(arr);
        System.out.println("Sorted  : " + Arrays.toString(arr));

        // Binary search (on sorted array)
        int idx = Arrays.binarySearch(arr, 45);
        System.out.println("Index of 45 in sorted array: " + idx);
    }
}
