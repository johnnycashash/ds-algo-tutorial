package com.ds.algo.designpattern.structural.proxy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Proxy Pattern – control access to a real object.
 *
 * KEY IDEA: VpnProxy implements the same Internet interface as DirectInternet,
 *           but adds access-control logic (blocked URLs) before delegating.
 *
 * Types of Proxy:
 *   - Protection Proxy (this example) – controls access.
 *   - Virtual Proxy  – lazy-loads expensive objects.
 *   - Remote Proxy   – represents objects in a different address space (e.g. RMI).
 *   - Caching Proxy  – caches results.
 */
public class VpnProxy implements Internet {
    private final Set<String> blockedUrls = new HashSet<>(Arrays.asList(
            "www.facebook.com", "www.instagram.com"
    ));
    private final Internet realInternet = new DirectInternet();

    @Override
    public void accessWebsite(String url) {
        if (blockedUrls.contains(url)) {
            System.out.println("⛔ Blocked: " + url);
            return;
        }
        realInternet.accessWebsite(url);
    }
}
