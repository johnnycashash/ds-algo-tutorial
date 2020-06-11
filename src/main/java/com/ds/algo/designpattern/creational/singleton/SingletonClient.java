package com.ds.algo.designpattern.creational.singleton;

public class SingletonClient {
    public static void main(String[] args) {
        ApplicationContext instance = ApplicationContext.getInstance();
        ApplicationContext instance1 = ApplicationContext.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode() == instance1.hashCode());
    }
}
