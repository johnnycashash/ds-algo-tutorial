package com.ds.algo.algorithm.other;

/**
 * LCM (Least Common Multiple).
 *
 * KEY FORMULA:  lcm(a, b) = (a * b) / gcd(a, b)
 *
 * Time: O(log(min(a,b)))  (dominated by GCD)
 */
public class Lcm {

    /** Preferred approach – uses the GCD relationship. */
    public static int lcm(int a, int b) {
        return (a / HcfAkaGcdEuclid.gcdIterative(a, b)) * b;   // divide first to avoid overflow
    }

    /** Brute-force approach – keep adding the larger until divisible by smaller. */
    public static int lcmBruteForce(int a, int b) {
        int large = Math.max(a, b);
        int small = Math.min(a, b);
        int multiple = large;
        while (multiple % small != 0) {
            multiple += large;
        }
        return multiple;
    }

    public static void main(String[] args) {
        System.out.println("LCM(7,3) via GCD    = " + lcm(7, 3));           // 21
        System.out.println("LCM(7,3) brute      = " + lcmBruteForce(7, 3)); // 21
        System.out.println("LCM(12,18) via GCD  = " + lcm(12, 18));         // 36
    }
}
