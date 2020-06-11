package com.ds.algo.designpattern.structural.proxy;

public class DirectInternet implements Internet {
    public void accessWebsite(String url) {
        System.out.println("Opening " + url);
    }
}
