package com.ds.algo.multithreading.threadpool;

/**
 * Custom Thread Pool (interview-classic: "implement your own ThreadPoolExecutor").
 *
 * KEY IDEA:
 *   - A fixed number of Worker threads run in an infinite loop.
 *   - Tasks are submitted to a BlockingQueue.
 *   - Each worker calls queue.take() (blocks until a task is available), then runs it.
 *   - shutdown() sets a flag and interrupts all workers.
 *
 * This is essentially how java.util.concurrent.ThreadPoolExecutor works internally.
 */
public interface CustomThreadPoolExecutor {
    void addTask(Task task);

    void shutdown();
}
