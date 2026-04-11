package com.ds.algo.algorithm.other;

/**
 * Prime Number check & Sieve.
 *
 * KEY IDEA: A number n is prime if no integer from 2..√n divides it.
 *           Check 2 separately, then only odd numbers up to √n.
 *
 * Time: O(√n) per check
 */
public class PrimeNumber {

    /** Check if a single number is prime. */
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;               // 2 and 3 are prime
        if (n % 2 == 0 || n % 3 == 0) return false;
        // Check 6k ± 1 up to √n  (all primes > 3 are of form 6k±1)
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    /** Print all primes up to limit. */
    public static void printPrimesUpTo(int limit) {
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Primes up to 50:");
        printPrimesUpTo(50);
        // 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47
    }
}
