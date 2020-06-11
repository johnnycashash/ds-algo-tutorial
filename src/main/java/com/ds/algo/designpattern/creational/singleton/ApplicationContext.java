package com.ds.algo.designpattern.creational.singleton;

public class ApplicationContext {
    private static volatile ApplicationContext applicationContext;

    private ApplicationContext() {
        if (applicationContext != null) {
            throw new RuntimeException("Cannot create applicationContext");
        }
        System.out.println("Creating applicationContext");
    }

    public static ApplicationContext getInstance() {
        if (applicationContext == null) {
            synchronized (ApplicationContext.class) {
                if (applicationContext == null) {
                    applicationContext = new ApplicationContext();
                }
            }
        }
        return applicationContext;
    }
    //for cloning: In clone method: return applicationContext or throw CloneNotSupportedException
    //for serialization: In readResolve(called after deserialization is done) method: return applicationContext
    //for reflection use Enums Singleton instance as enums don't support constructors
}
