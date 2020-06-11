package com.ds.algo.multithreading.threadpool;

public class ThreadPoolClient {
    public static void main(String[] args) throws InterruptedException {
        CustomThreadPoolExecutor threadPoolExecutor = new CustomThreadPoolExecutorImpl(2);

        threadPoolExecutor.addTask(() -> System.out.println(Thread.currentThread().getName() + " - 1 print task"));
        threadPoolExecutor.addTask(() -> {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " - 2 print task");
        });
        threadPoolExecutor.addTask(() -> System.out.println(Thread.currentThread().getName() + " - 3 print task"));
        threadPoolExecutor.addTask(() -> System.out.println(Thread.currentThread().getName() + " - 4 print task"));
        Thread.sleep(2000);
        threadPoolExecutor.shutdown();
    }
}
