package com.javaquasar.java.core.chapter_06_Loops.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Sum2 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int n = scanner.nextInt();
        double y = 0;
        for (int i = 1; i <= n; i++) {
            if (x == i) {
                System.err.println("Ошибка!\n");
                return; // досрочное завершение программы
            }
            y += 1 / (x - i);
        }
        System.out.println("y = " + y);
    }
}
