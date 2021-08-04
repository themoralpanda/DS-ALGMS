package com.dsalgms;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        InsertionSort iSort = new InsertionSort();
        System.out.println(Arrays.toString(iSort.sortIntegerArray(new int[]{100,25,39,-75,-10,500})));
        System.out.println(Arrays.toString(iSort.sortIntegerArray(new int[]{1,-20})));

    }
}
