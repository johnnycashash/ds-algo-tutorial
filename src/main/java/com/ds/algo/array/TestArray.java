package com.ds.algo.array;

public class TestArray {
    public static void main(String[] args) {
        int[] intArray=new int[7];

        intArray[0]=20;
        intArray[1]=-1;
        intArray[2]=20;
        intArray[3]=45;
        intArray[4]=2;
        intArray[5]=7;
        intArray[6]=222;
        System.out.println(intArray.length);
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

}
