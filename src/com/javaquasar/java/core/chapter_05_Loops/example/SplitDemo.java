package com.javaquasar.java.core.chapter_05_Loops.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SplitDemo {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        int n;
        System.out.println("Input n:");
        n = new Scanner(System.in).nextInt();
        int y = 0;
        for (int i = 1; i <= n; i++)
            y += i * i;
        System.out.println("y = " + y);
    }

}
