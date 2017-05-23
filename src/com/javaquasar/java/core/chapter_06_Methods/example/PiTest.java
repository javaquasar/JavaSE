package com.javaquasar.java.core.chapter_06_Methods.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class PiTest {

    static double pi(double eps) {
        double sum = 0;
        double k = 1;
        double z = 4;
        double i = 1;
        while (Math.abs(z) > eps) {
            sum += z;
            i += 2;
            k = -k;
            z = (4 * k) / i;
        }
        return sum;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double eps = scanner.nextDouble();
        double y = pi(eps);
        System.out.println(y);
    }

}
