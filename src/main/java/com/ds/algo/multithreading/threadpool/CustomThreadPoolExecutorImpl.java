package com.ds.algo.multithreading.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Implementation of a simple thread pool.
 *
 * Workers continuously poll the queue. When shutdown() is called,
 * we set volatile flag + interrupt all workers so blocked take() throws.
 */
public class CustomThreadPoolExecutorImpl implements CustomThreadPoolExecutor {
    private final BlockingQueue<Task> taskQueue;
    private final Worker[] workers;
    private volatile boolean shutdown;      // volatile for visibility across threads

    public CustomThreadPoolExecutorImpl(int numThreads) {
        taskQueue = new LinkedBlockingQueue<>();
        workers = new Worker[numThreads];
        for (int i = 0; i < numThreads; i++) {
            workers[i] = new Worker("Pool-Thread-" + (i + 1));
            workers[i].start();
        }
    }

    @Override
    public void addTask(Task task) {
        if (shutdown) throw new IllegalStateException("ThreadPool is shut down");
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void shutdown() {
        shutdown = true;
        for (Worker w : workers) {
            w.interrupt();      // unblocks take() if waiting
        }
    }

    /** Worker thread – takes tasks from queue and runs them. */
    private class Worker extends Thread {
        Worker(String name) { super(name); }

        @Override
        public void run() {
            while (!shutdown) {
                try {
                    taskQueue.take().run();  // blocks until task available
                } catch (InterruptedException e) {
                    // shutdown was called → exit loop
                }
            }
        }
    }
}
