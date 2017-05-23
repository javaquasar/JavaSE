package com.javaquasar.java.core.chapter_06_Methods.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class RecursionTest {

    static double power(double x, int n) {
        if (n < 0)
            return 1 / power(x, -n);
        if (n == 0)
            return 1;
        return x * power(x, n - 1);
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
