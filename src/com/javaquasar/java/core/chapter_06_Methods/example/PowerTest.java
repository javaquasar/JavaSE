package com.javaquasar.java.core.chapter_06_Methods.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class PowerTest {

    static double power(double x, int n) {
        double p = 1;
        if (n >= 0) {
            for (int i = 1; i <= n; i++)
                p *= x;
            return p;
        } else {
            for (int i = 1; i <= -n; i++)
                p *= x;
            return 1 / p;
        }
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int n = scanner.nextInt();
        double y = power(x, n);
        System.out.println(y);
    }

}
