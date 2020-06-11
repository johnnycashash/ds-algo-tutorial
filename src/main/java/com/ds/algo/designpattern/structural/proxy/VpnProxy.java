package com.ds.algo.designpattern.structural.proxy;

import java.util.ArrayList;
import java.util.List;

public class VpnProxy implements Internet {
    List<String> blockedUrl = new ArrayList<String>();
    DirectInternet directInternet = new DirectInternet();

    VpnProxy() {
        blockedUrl.add("www.facebook.com");
        blockedUrl.add("www.instagram.com");
    }

    public void accessWebsite(String url) {
        if (blockedUrl.contains(url)) {
            System.out.println("This url is in the list of blocked Url's");
            return;
        }
        directInternet.accessWebsite(url);
    }
}
