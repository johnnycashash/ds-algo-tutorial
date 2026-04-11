package com.ds.algo.algorithm.search;

/**
 * Linear Search – works on ANY array (sorted or not).
 *
 * Idea:  Walk through every element until you find the target.
 *
 * Time : O(n)   Space: O(1)
 */
public class LinearSearch {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        int[] arr = {54, 848, 4, 8, 6, 777, 4, 2, 7};
        System.out.println("Index of 6 : " + linearSearch(arr, 6));   // 4
        System.out.println("Index of 99: " + linearSearch(arr, 99));  // -1
    }
}
