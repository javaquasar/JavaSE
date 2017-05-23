package com.javaquasar.java.core.chapter_05_Loops.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 *//**
 * Created by Java Quasar on 16.05.17.
 */
public class Sum {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int n = scanner.nextInt();
        double y = 0;
        int i;
        for (i = 1; i <= n; i++) {
            if (x == i) {
                System.err.println("Ошибка!\n");
                break; // выход из цикла
            }
            y += 1 / (x - i);
        }
        if (i > n) // сумма посчитана
            System.out.println("y = " + y);
    }

}
