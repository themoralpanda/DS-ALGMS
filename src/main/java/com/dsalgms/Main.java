package com.dsalgms;



public class Main {
    static class Temp {
        int a;
    }
    public static void main(String args[]) {
        Temp t1 = new Temp();
        t1.a = 2;
        Temp t2 = t1;
        Temp t3 = t2;

        t2.a = 5;
        System.out.println(t3.a);

    }
}
