package com.javaquasar.java.core.chapter_06_Methods.example;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Sum {

    public static double sum(int n) {
        if (n <= 1)
            return 1;
        else
            return n * n + sum(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(5));
    }

}