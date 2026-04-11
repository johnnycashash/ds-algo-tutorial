package com.ds.algo.designpattern.creational.singleton;

/**
 * Singleton Pattern – ensure a class has exactly ONE instance.
 *
 * This uses DOUBLE-CHECKED LOCKING (thread-safe, lazy initialization).
 *
 * HOW IT WORKS:
 *   1. Private constructor → prevents external instantiation.
 *   2. volatile field      → ensures visibility across threads.
 *   3. Double-check inside synchronized → avoids locking after first creation.
 *
 * BREAKING SINGLETON (interview follow-up):
 *   - Reflection   → guard: throw exception in constructor if instance exists.
 *   - Cloning      → override clone() to return existing instance.
 *   - Serialization→ implement readResolve() to return existing instance.
 *   - BEST FIX     → Use Enum singleton (immune to all three).
 */
public class ApplicationContext {
    private static volatile ApplicationContext instance;

    private ApplicationContext() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() – reflection not allowed!");
        }
        System.out.println("ApplicationContext created");
    }

    public static ApplicationContext getInstance() {
        if (instance == null) {                          // 1st check (no lock)
            synchronized (ApplicationContext.class) {
                if (instance == null) {                  // 2nd check (with lock)
                    instance = new ApplicationContext();
                }
            }
        }
        return instance;
    }
}
