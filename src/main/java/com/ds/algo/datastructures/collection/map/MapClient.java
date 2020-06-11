package com.ds.algo.datastructures.collection.map;

public class MapClient {
    public static void main(String[] args) {
        CustomHashMap<String, String> myMap = new CustomHashMap<>();
        myMap.put("USA", "Washington DC");
        myMap.put("Nepal", "Kathmandu");
        myMap.put("India", "New Delhi");
        myMap.put("Australia", "Sydney");
        System.out.println(myMap);
        System.out.println(myMap.size());
        System.out.println(myMap.get("Nepal"));
        System.out.println(myMap.get("Australia"));
    }
}
