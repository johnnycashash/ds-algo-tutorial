package com.ds.algo.algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Prime Factorisation.
 *
 * KEY IDEA: Divide by the smallest possible factor (starting from 2)
 *           repeatedly until the number becomes 1.
 *
 * Time: O(√n)  – because once we divide all small factors, the loop ends quickly.
 * Space: O(log n) for the result list
 */
public class PrimeFactors {

    public static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        // Divide by 2 first (handle all even factors)
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        // Now n is odd. Try odd divisors from 3 to √n.
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        // If n is still > 1, then it is a prime factor itself.
        if (n > 1) factors.add(n);
        return factors;
    }

    public static void main(String[] args) {
        System.out.println("Prime factors of 44 : " + primeFactors(44));  // [2, 2, 11]
        System.out.println("Prime factors of 3  : " + primeFactors(3));   // [3]
        System.out.println("Prime factors of 32 : " + primeFactors(32));  // [2, 2, 2, 2, 2]
        System.out.println("Prime factors of 60 : " + primeFactors(60));  // [2, 2, 3, 5]
    }
}
