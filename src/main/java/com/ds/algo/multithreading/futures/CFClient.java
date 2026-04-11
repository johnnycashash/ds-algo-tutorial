package com.ds.algo.multithreading.futures;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture Cheat-Sheet – common interview patterns.
 *
 * KEY METHODS:
 *   supplyAsync   → run async task that RETURNS a value
 *   thenApply     → transform result (like map)
 *   thenCompose   → chain another CF (like flatMap)
 *   thenCombine   → combine results of two CFs
 *   thenAccept    → consume result (no return)
 *   exceptionally → handle exceptions
 *   handle        → handle both success and failure
 *   join/get      → block and get result
 */
public class CFClient {
    public static void main(String[] args) {

        // ─── 1. Basic: supplyAsync → thenApply → thenAccept ───
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> s + " World")
                .thenAccept(s -> System.out.println("1. " + s));     // Hello World

        // ─── 2. Exception handling ───
        CompletableFuture.supplyAsync(() -> {
                    if (true) throw new RuntimeException("Oops!");
                    return "OK";
                })
                .exceptionally(ex -> "Recovered: " + ex.getMessage())
                .thenAccept(s -> System.out.println("2. " + s));     // Recovered: ...

        // ─── 3. handle() – handles both success and failure ───
        String result = CompletableFuture.supplyAsync(() -> "Data")
                .handle((val, ex) -> {
                    if (ex != null) return "Error";
                    return val.toUpperCase();
                }).join();
        System.out.println("3. " + result);                          // DATA

        // ─── 4. thenCompose – chaining (flatMap style) ───
        CompletableFuture<Integer> composed = CompletableFuture.supplyAsync(() -> 5)
                .thenCompose(n -> CompletableFuture.supplyAsync(() -> n * 2));
        System.out.println("4. thenCompose: " + composed.join());    // 10

        // ─── 5. thenCombine – combine two independent CFs ───
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 20);
        int combined = cf1.thenCombine(cf2, Integer::sum).join();
        System.out.println("5. thenCombine: " + combined);           // 30

        // ─── 6. allOf – wait for multiple CFs ───
        CompletableFuture<Void> all = CompletableFuture.allOf(cf1, cf2);
        all.join();
        System.out.println("6. All done");
    }
}
