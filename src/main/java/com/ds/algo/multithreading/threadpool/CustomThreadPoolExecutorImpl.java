package com.ds.algo.multithreading.threadpool;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExecutorImpl implements CustomThreadPoolExecutor {
    private final BlockingQueue<Task> workerQueue;
    private final Worker[] workerThreads;
    private boolean interrupt;

    public CustomThreadPoolExecutorImpl(int numThreads) {
        workerQueue = new LinkedBlockingQueue<>();
        workerThreads = new Worker[numThreads];
        for (int i = 0; i < workerThreads.length; i++) {
            workerThreads[i] = new Worker("Custom Pool Thread " + (i + 1));
            workerThreads[i].start();
        }
    }

    public void addTask(Task r) {
        try {
            workerQueue.put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        this.interrupt = true;

        for (Worker t : workerThreads) {
            t.interrupt();
        }
    }

    class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (!interrupt) {
                try {
                    //Both take and run can be interrupted when any of them is in wait or sleep and this.interrupt is called
                    //run will execute synchronous in this thread and block this thread until complete or interrupted
                    workerQueue.take().run();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
        }
    }
}

