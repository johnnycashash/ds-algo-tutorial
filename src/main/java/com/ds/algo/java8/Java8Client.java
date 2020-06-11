package com.ds.algo.java8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Client {
    public static void main(String[] args) {
        String name = "jjhhtylsdjfkkkfffeks";
        Map<Character, Long> collect1 = name.chars().boxed().collect(Collectors.groupingBy(integer -> (char) (int) integer, Collectors.counting()));
        System.out.println(collect1);
        List<String> l = new ArrayList<>();
//        l.add("a");
//        l.add("aa");
//        l.add("sa");
//        l.add("af");
//        l.add("qa");
//        l.add("ae");
//        l.add("ra");
        l.add("at");
        l.add("bqq");
        System.out.println(l.stream().collect(Collectors.toMap(s -> s.charAt(0), s -> s.toCharArray())));
        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        //   System.out.println(list);
        Map<String, String> collect = list
                .stream()
                .flatMap(new Function<List<String>, Stream<? extends String>>() {
                    @Override
                    public Stream<? extends String> apply(List<String> strings) {
                        return strings.stream();
                    }
                })
                .collect(Collectors.toMap(String::toUpperCase, String::toUpperCase, (s, s2) -> s + s2));
//        ObjectMapper objectMapper=new ObjectMapper();
//        objectMapper.readValue()
//                obje
//        new ArrayList<>().stream().collect(Collectors.toList());
//        System.out.println(collect1);
    }
}
