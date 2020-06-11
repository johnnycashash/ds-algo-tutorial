package com.ds.algo.designpattern.structural.proxy;

public class ProxyClient {
    public static void main(String[] args) {
        Internet vpnProxy = new VpnProxy();
        vpnProxy.accessWebsite("www.google.com");
        vpnProxy.accessWebsite("www.facebook.com");
    }

}
