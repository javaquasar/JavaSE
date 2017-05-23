package com.javaquasar.java.core.chapter_06_Methods.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ExpressionTest {

    static double f(double x) {
        return x < -8 ? 100 : (x <= 1 ? 200 : 300);
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double y = f(x);
        System.out.println(y);
    }

}
