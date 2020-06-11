package com.ds.algo.multithreading.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.*;

public class CFClient {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Integer> handle = CompletableFuture.supplyAsync(() -> {
            //System.out.println(Thread.currentThread().getName());
            int t = 3 / 0;

            return 2;
        }).thenApply(integer -> {
            // System.out.println(Thread.currentThread().getName());
            return integer + 2;
        }).exceptionally(throwable -> {
            System.out.println("exceptionally" + throwable);
            return 9;
        }).handle((integer, throwable) -> {
            System.out.println(integer);
            System.out.println(throwable);
            return 1;
        }).thenApply(integer -> integer + 3);
        handle.thenAccept(integer -> System.out.println(integer));
        handle.complete(1);
        CompletableFuture<Integer> handle1 = CompletableFuture.supplyAsync(() -> {
            //System.out.println(Thread.currentThread().getName());

            return 2;
        }).thenCompose(integer -> {
            //System.out.println(Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> {
                //System.out.println(Thread.currentThread().getName());

                return integer + 8;
            });
        }).exceptionally(throwable -> {
            // System.out.println(throwable);
            return 9;
        });
        handle.thenCombine(handle1, (integer, integer2) -> integer + integer2).thenAccept(integer -> System.out.println(integer));
        // System.out.println(Thread.currentThread().getName());
        Predicate<Integer> stringPredicate = (i) -> i > 8;
        Supplier<String> stringSupplier = () -> "jagan";
        Consumer<String> stringConsumer = (i) -> System.out.println(i);
        Function<String, Integer> integerStringFunction = (s) -> Integer.valueOf(s);
        BiFunction<String, String, Integer> stringStringIntegerBiFunction = (s, t) -> Integer.valueOf(s + t);
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName());

                //Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "message";
        }).thenApplyAsync(s -> {
            System.out.println(Thread.currentThread().getName());
            // randomSleep();
            return s.toUpperCase();
        });
        System.out.println(cf.getNow(null));
        cf.join();

    }
}
