package com.ds.algo.designpattern.structural.adapter;

public class PencilAdapter implements Pen {
    Pencil pencil;

    public PencilAdapter(Pencil pencil) {
        this.pencil = pencil;
    }

    public void work() {
        pencil.erasableWork();
    }
}
