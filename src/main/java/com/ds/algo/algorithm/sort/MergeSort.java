package com.ds.algo.algorithm.sort;

import java.util.Arrays;

/**
 * Merge Sort – classic divide-and-conquer sort.
 *
 * KEY IDEA:
 *   1. Split array in half recursively until single elements.
 *   2. Merge two sorted halves back together.
 *
 * Time : O(n log n) always     Space: O(n) – needs temp arrays
 * Stable: YES
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;                          // base case: 0 or 1 element

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);                          // sort left half
        mergeSort(arr, mid + 1, right);                     // sort right half
        merge(arr, left, mid, right);                       // merge both halves
    }

    /**
     * Merge arr[left..mid] and arr[mid+1..right] into arr[left..right].
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];    // <= keeps sort STABLE
            else                  temp[k++] = arr[j++];
        }
        while (i <= mid)  temp[k++] = arr[i++];            // remaining left
        while (j <= right) temp[k++] = arr[j++];           // remaining right

        System.arraycopy(temp, 0, arr, left, temp.length);  // copy back
    }

    // ──────────── demo ────────────
    public static void main(String[] args) {
        int[] arr = {12, 1, 10, 50, 5, 15, 45};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));           // [1, 5, 10, 12, 15, 45, 50]
    }
}