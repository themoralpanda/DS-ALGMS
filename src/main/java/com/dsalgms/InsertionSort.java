package com.dsalgms;

import java.util.Arrays;

public class InsertionSort {
    public int[] sortIntegerArray(int[] a) {
        for(int j=1;j<a.length;j++) {
            for(int i=j-1,k=j;i>=0;i--,k--) {
                if(a[k] < a[i]) {
                    int c = a[k];
                    a[k] = a[i];
                    a[i] = c;
                }

            }
        }
        System.out.println(Arrays.toString(a));
        return a;
    }
}
