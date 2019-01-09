package com.ds.algo.algorithm;

public class Lcm {
    public static int findLCM(int a, int b) {
        int large = a > b ? a : b;
        int small = a > b ? b : a;
        int i = large;
        while (true) {
            if (i % small == 0) {
                return i;
            }
            i += large;
        }
    }

    public static void main(String[] args) {
        int a = 7, b = 3;
        int gcd = HcfAkaGcdEuclid.gcdNonRecursion(a, b);
        System.out.println("Lcm " + (a * b) / gcd);
        System.out.println("Lcm " + findLCM(a, b));
    }
}
