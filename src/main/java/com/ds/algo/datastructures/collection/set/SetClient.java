package com.ds.algo.datastructures.collection.set;

/** Demo: Custom HashSet – duplicates are ignored. */
public class SetClient {
    public static void main(String[] args) {
        CustomHashSet<String> set = new CustomHashSet<>();
        System.out.println("add 'jag' : " + set.add("jag"));    // true
        System.out.println("add 'an'  : " + set.add("an"));     // true
        System.out.println("add 'sin' : " + set.add("sin"));    // true
        System.out.println("add 'jag' : " + set.add("jag"));    // false (duplicate!)
        System.out.println("Set       : " + set);               // [jag, an, sin]
        System.out.println("contains  : " + set.contains("an"));// true
        System.out.println("size      : " + set.size());        // 3
    }
}
