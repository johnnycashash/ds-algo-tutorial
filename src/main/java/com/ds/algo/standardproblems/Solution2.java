package com.ds.algo.standardproblems;

import java.util.Arrays;

/**
 * Classic Interview Problems – Part 3 (Array manipulation).
 */
public class Solution2 {

    // ═══════════════════════════════════════════════════════════════
    // 1. ROTATE ARRAY LEFT by k positions
    //    LeetCode #189 (variant)
    //    Time: O(n)  Space: O(1)   — Three-reverse trick
    // ═══════════════════════════════════════════════════════════════

    /**
     * To rotate left by k:
     *   1. Reverse [0..k-1]
     *   2. Reverse [k..n-1]
     *   3. Reverse entire array
     *
     * Example: [1,2,3,4,5,6] rotate left 2 → [3,4,5,6,1,2]
     */
    public static void rotateLeft(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // 2. MINIMUM BRACKET REVERSALS to balance parentheses
    //    Time: O(n)  Space: O(1)
    // ═══════════════════════════════════════════════════════════════

    /**
     * Track balance: '(' → +1, ')' → -1.
     * If balance goes to -1, we need one reversal → increment answer, reset balance.
     * At end, remaining balance = unmatched '(' → need balance/2 more reversals.
     * Total = answer + remaining balance.
     */
    public static int minBracketReversals(String str) {
        int answer = 0, balance = 0;
        for (char c : str.toCharArray()) {
            balance += (c == '(') ? 1 : -1;
            if (balance == -1) {
                answer++;
                balance = 1;   // flip ) to (
            }
        }
        return answer + balance;  // unmatched opening brackets
    }

    // ═══════════════════════════════════════════════════════════════
    // 3. SWAP TWO NUMBERS without temp variable
    //    Time: O(1)  Space: O(1)
    // ═══════════════════════════════════════════════════════════════

    /** XOR swap – works for integers, no overflow risk. */
    public static void swapWithoutTemp(int a, int b) {
        System.out.println("Before: a=" + a + ", b=" + b);
        a = a ^ b;
        b = a ^ b;   // (a^b)^b = a
        a = a ^ b;   // (a^b)^a = b
        System.out.println("After : a=" + a + ", b=" + b);
    }

    // ═══════════════════════════════════════════════════════════════
    // 4. PRINT ALL SUBARRAYS
    //    Time: O(n³)  Space: O(1)
    // ═══════════════════════════════════════════════════════════════

    public static void printAllSubarrays(int[] arr) {
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                System.out.print("[");
                for (int k = start; k <= end; k++) {
                    if (k > start) System.out.print(", ");
                    System.out.print(arr[k]);
                }
                System.out.println("]");
            }
        }
    }

    // ──────────── Demo ────────────
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        rotateLeft(arr, 2);
        System.out.println("Rotate left 2  : " + Arrays.toString(arr));  // [3,4,5,6,1,2]

        System.out.println("Min reversals  : " + minBracketReversals(")))("));  // 3

        swapWithoutTemp(25, 8);

        System.out.println("\nAll subarrays of [1,2,3]:");
        printAllSubarrays(new int[]{1, 2, 3});
    }
}
