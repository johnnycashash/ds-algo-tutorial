package com.ds.algo.designpattern.structural.adapter;

/**
 * Adapter Pattern – makes an incompatible interface work with an expected one.
 *
 * KEY IDEA: Pencil has method erasableWork(), but Student expects Pen.work().
 *           PencilAdapter wraps Pencil and implements Pen, bridging the gap.
 *
 *   Student → uses Pen interface
 *   PencilAdapter implements Pen, wraps Pencil → calls pencil.erasableWork()
 *
 * Real-world: InputStreamReader adapts InputStream (bytes) to Reader (chars).
 */
public class PencilAdapter implements Pen {
    private final Pencil pencil;

    public PencilAdapter(Pencil pencil) {
        this.pencil = pencil;
    }

    @Override
    public void work() {
        pencil.erasableWork();      // delegate to the incompatible method
    }
}
