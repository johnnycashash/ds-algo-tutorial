package com.ds.algo.algorithm.search;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{2, 3, 5, 6, 8, 10}, 8));
    }

    public static int binarySearch(int[] array, int value) {
        int start = 0;
        int end = array.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}
