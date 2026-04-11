package com.ds.algo.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Java 8 Features Cheat-Sheet – common interview scenarios.
 */
public class Java8Client {
    public static void main(String[] args) {

        // ─── 1. Character Frequency Map ───
        String name = "interview";
        Map<Character, Long> charFreq = name.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("Char freq: " + charFreq);

        // ─── 2. Filter, Map, Collect ───
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Anna");
        List<String> aNames = names.stream()
                .filter(n -> n.startsWith("A"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("A-names : " + aNames);  // [ALICE, ANNA]

        // ─── 3. FlatMap – flatten nested lists ───
        List<List<String>> nested = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"));
        List<String> flat = nested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("Flat    : " + flat);     // [a, b, c, d]

        // ─── 4. toMap with merge function (handle duplicates) ───
        List<String> words = Arrays.asList("apple", "ant", "ball", "bat");
        Map<Character, String> firstCharMap = words.stream()
                .collect(Collectors.toMap(
                        w -> w.charAt(0),       // key
                        w -> w,                 // value
                        (v1, v2) -> v1 + "," + v2  // merge duplicates
                ));
        System.out.println("Map     : " + firstCharMap);  // {a=apple,ant, b=ball,bat}

        // ─── 5. Sorting with Comparator ───
        List<String> sorted = names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("By len  : " + sorted);

        // ─── 6. Optional ───
        Optional<String> opt = names.stream()
                .filter(n -> n.startsWith("Z"))
                .findFirst();
        System.out.println("Found Z?: " + opt.orElse("Nobody"));

        // ─── 7. Reduce – sum of lengths ───
        int totalLen = names.stream()
                .map(String::length)
                .reduce(0, Integer::sum);
        System.out.println("Total len: " + totalLen);
    }
}
