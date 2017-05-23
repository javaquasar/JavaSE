package com.javaquasar.java.core.chapter_06_Methods.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class PiWithRecursion {

    static double pi(double eps, int n) {
        double z = 4.0 / n;
        if (z < eps)
            return z;
        return z - pi(eps, n + 2);
    }

    static double pi(double eps) {
        return pi(eps, 1);
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double eps = scanner.nextDouble();
        double y = pi(eps);
        System.out.println(y);
    }

}
