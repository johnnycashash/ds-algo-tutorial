package com.ds.algo.multithreading.threadpool;

public interface CustomThreadPoolExecutor {
    void addTask(Task r);

    void shutdown();
}
