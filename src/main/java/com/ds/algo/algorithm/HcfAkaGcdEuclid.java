package com.ds.algo.algorithm;

public class HcfAkaGcdEuclid {
    public static int gcdRecursion(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdRecursion(b, a % b);
    }

    public static int gcdNonRecursion(int a, int b) {
        int t = 0;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    //Euclid theorem says gcd(a,b) = gcd(b,a%b)
    //and gcd(a,0) = a
    //using above two concept this algo is produced
    public static void main(String[] args) {
        int a = 12;
        int b = 18;
        System.out.println(gcdNonRecursion(a, b) == gcdRecursion(a, b));
    }
}
