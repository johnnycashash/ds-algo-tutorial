package com.ds.algo.algorithm.other;

/**
 * GCD (Greatest Common Divisor) using Euclid's Algorithm.
 *
 * KEY IDEA (Euclid's theorem):
 *   gcd(a, b) = gcd(b, a % b)
 *   gcd(a, 0) = a
 *
 * Time: O(log(min(a,b)))   Space: O(1) iterative / O(log(min(a,b))) recursive stack
 */
public class HcfAkaGcdEuclid {

    /** Recursive – easiest to remember. */
    public static int gcdRecursive(int a, int b) {
        if (b == 0) return a;
        return gcdRecursive(b, a % b);
    }

    /** Iterative – avoids stack overhead. */
    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("GCD(12,18) = " + gcdIterative(12, 18));    // 6
        System.out.println("GCD(12,18) = " + gcdRecursive(12, 18));    // 6
        System.out.println("GCD(7,3)   = " + gcdIterative(7, 3));      // 1
    }
}
