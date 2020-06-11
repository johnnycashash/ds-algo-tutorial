package com.ds.algo.multithreading.threadpool;

@FunctionalInterface
public interface Task {

    void run() throws InterruptedException;
}
