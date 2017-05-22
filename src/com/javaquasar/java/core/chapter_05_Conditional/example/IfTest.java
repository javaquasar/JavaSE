package com.javaquasar.java.core.chapter_05_Conditional.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class IfTest {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double y;
        if (x < -8)
            y = 100;
        else if (x <= 1)
            y = 200;
        else
            y = 300;
        System.out.println(y);
    }

}
