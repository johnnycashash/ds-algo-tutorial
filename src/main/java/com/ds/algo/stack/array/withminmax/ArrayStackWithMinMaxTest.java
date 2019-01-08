package com.ds.algo.stack.array.withminmax;

public class ArrayStackWithMinMaxTest {
    public static void main(String[] args) {
        ArrayStackWithMinMax arrayStackWithMinMax=new ArrayStackWithMinMax(3);
        arrayStackWithMinMax.push(4);
        arrayStackWithMinMax.push(6);
        arrayStackWithMinMax.push(2);
        System.out.println(arrayStackWithMinMax.getMax());
        System.out.println(arrayStackWithMinMax.getMin());

    }
}
