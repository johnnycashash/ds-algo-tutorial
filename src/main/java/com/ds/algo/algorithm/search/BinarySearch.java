package com.ds.algo.algorithm.search;

/**
 * Binary Search – works only on SORTED arrays.
 *
 * Idea:  Compare target with the middle element.
 *        Discard the half where target cannot lie.
 *
 * Time : O(log n)   Space: O(1)
 */
public class BinarySearch {

    /**
     * Iterative binary search.
     * @return index of value, or -1 if not found
     */
    public static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;          // inclusive on both ends

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;          // avoids integer overflow
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) lo = mid + 1;
            else                        hi = mid - 1;
        }
        return -1;                                 // not found
    }

    /**
     * Recursive binary search (good to know for interviews).
     */
    public static int binarySearchRecursive(int[] arr, int target, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) return binarySearchRecursive(arr, target, mid + 1, hi);
        return binarySearchRecursive(arr, target, lo, mid - 1);
    }

    // ──────────── demo ────────────
    public static void main(String[] args) {
        int[] sorted = {2, 3, 5, 6, 8, 10};
        System.out.println("Iterative  → index of 8 : " + binarySearch(sorted, 8));          // 4
        System.out.println("Recursive  → index of 5 : "
                + binarySearchRecursive(sorted, 5, 0, sorted.length - 1));                    // 2
        System.out.println("Not found  → index of 7 : " + binarySearch(sorted, 7));          // -1
    }
}
