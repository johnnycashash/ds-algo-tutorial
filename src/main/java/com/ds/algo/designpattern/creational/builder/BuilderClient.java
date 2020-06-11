package com.ds.algo.designpattern.creational.builder;

public class BuilderClient {
    public static void main(String[] args) {
        Computer build = new Computer.Builder(2048, 512).setGraphics(false).build();
        System.out.println(build);
    }
}
