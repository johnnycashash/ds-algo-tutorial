package com.ds.algo.algorithm.search;

public class LinearSearch {
    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{54, 848, 4, 8, 6, 777, 4, 2, 7}, 6));
    }

    public static int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
