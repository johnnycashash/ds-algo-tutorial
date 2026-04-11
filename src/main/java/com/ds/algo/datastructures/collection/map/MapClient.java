package com.ds.algo.datastructures.collection.map;

/** Demo: Custom HashMap operations. */
public class MapClient {
    public static void main(String[] args) {
        CustomHashMap<String, String> map = new CustomHashMap<>();
        map.put("USA", "Washington DC");
        map.put("Nepal", "Kathmandu");
        map.put("India", "New Delhi");
        map.put("Australia", "Canberra");

        System.out.println("Map      : " + map);
        System.out.println("Size     : " + map.size());          // 4
        System.out.println("Nepal    : " + map.get("Nepal"));    // Kathmandu

        map.put("India", "Mumbai");                               // overwrite
        System.out.println("India    : " + map.get("India"));    // Mumbai

        map.remove("USA");
        System.out.println("After rm : " + map);
        System.out.println("Size     : " + map.size());          // 3
    }
}
