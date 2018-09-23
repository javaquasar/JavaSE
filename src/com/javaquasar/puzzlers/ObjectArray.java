package com.javaquasar.puzzlers;

public class ObjectArray {

    public static void main(String[] args) {
        Object[] b = new Object[10];
        b[0] = 3;
        b[1] = new Integer(9);
        b[2] = "3";
        b[3] = new Integer(10);
        b[4] = 6.0;
        b[5] = new Double(8.0);
        b[6] = new Object();
        b[7] = null;
        b[8] = 12;
        b[9] = 36;

        Object[] a = new Object[10];
        a[0] = b;
        a[1] = new Integer(9);
        a[2] = "3";
        a[3] = b;
        a[4] = 6.0;
        a[5] = new Double(8.0);
        a[6] = new Object();
        a[7] = null;
        a[8] = b;
        a[9] = b;

        Object[] o = new Object[10];
        o[0] = b;
        o[1] = new Integer(9);
        o[2] = "3";
        o[3] = new Integer(10);
        o[4] = 6.0;
        o[5] = new Double(8.0);
        o[6] = new Object();
        o[7] = null;
        o[8] = a;
        o[9] = a;
    }

}
