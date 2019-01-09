package com.ds.algo.algorithm;

import java.util.stream.IntStream;

public class PrimeNumber {
    private static boolean isPrime(int num) {
        if (num == 2)
            return true;
        if (num < 2 || num % 2 == 0)
            return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0)
                return false;
        return true;
    }

    public static boolean isPrimeFunctionalStyle(int number) {
        return number > 1 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(i -> number % i == 0);
    }

    public static void printPrime(int end) {
        for (int i = 1; i < end; i++) {
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) {
        printPrime(100);
    }
}
