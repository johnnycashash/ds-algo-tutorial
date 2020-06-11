package com.ds.algo.standardproblems;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
       /* 2 3 5 12 1 76
        2 3 5 12 1 76

        2 3 5 12 1
        2 3 5 12
        2 3 5
        2 3
        2

        3 5 12 1 76
        5 12 1 76
        12 1 76
        1 76
        76*/
        //printSubArrays(new int[]{2, 3, 5, 12, 1, 76}, 0, 0);
        // System.out.println(reverseRetainingSpaces("internships at geeks for geekss"));
        // swapWithoutTemp(25, 8);
        //  sameValueLocation(new int[]{3, 0, 1, 34, 7, 9, 12, 90, 2});
        rotateLeft(new int[]{1, 2, 3, 4, 5, 6}, 2);
    }

    static void printSubArrays(int[] arr, int start, int end) {
        // Stop if we have reached the end of the array
        if (end == arr.length)
            return;

            // Increment the end point and start from 0
        else if (start > end)
            printSubArrays(arr, 0, end + 1);

            // Print the subarray and increment the starting point
        else {
            System.out.print("[");
            for (int i = start; i < end; i++) {
                System.out.print(arr[i] + ", ");
            }

            System.out.println(arr[end] + "]");
            printSubArrays(arr, start + 1, end);
        }

        return;
    }

    public static String reverseRetainingSpaces(String str) {
        str = str.trim();
        char[] chars = str.toCharArray();
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (chars[i] == ' ') {
                i++;
            }
            if (chars[j] == ' ') {
                j--;
            }
            swap(chars, i, j);
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void swapWithoutTemp(int i, int j) {
        System.out.println("i=" + i + " j=" + j);
        i = i * j; //+
        j = i / j; //-
        i = i / j; //-
        System.out.println("After swap");
        System.out.println("i=" + i + " j=" + j);

    }

    public static void indexInverse(int[] arr) {
        int[] inverse = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            inverse[arr[i]] = i;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = inverse[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void rotateLeft(int[] arr, int shift) {
        shift = shift % arr.length;

        reverse(arr, 0, shift - 1);
        reverse(arr, shift, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
