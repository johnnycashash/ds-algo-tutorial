package com.ds.algo.algorithm.sort;

import java.util.Arrays;

/**
 * Bubble Sort – repeatedly swap adjacent elements if they're in the wrong order.
 *
 * KEY IDEA: After each outer pass, the largest unsorted element "bubbles" to its correct position.
 *
 * Time : O(n²) worst / average,  O(n) best (with earlyExit flag)
 * Space: O(1) – in-place
 * Stable: YES
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;                // optimisation: early exit
            for (int j = 0; j < n - 1 - i; j++) {  // last i elements are already sorted
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;                    // array is already sorted
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 84, 846, 44, 2, 55};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));   // [1, 2, 5, 44, 55, 84, 846]
    }
}
