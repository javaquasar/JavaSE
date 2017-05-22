package com.javaquasar.java.core.chapter_05_Conditional.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 *//**
 * Created by Java Quasar on 16.05.17.
 */
public class SwitchTest {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int n = scanner.nextInt();
        double y;
        switch (n) {
            case 1:
                y = x;
                break;
            case 2:
                y = x * x;
                break;
            case 3:
                y = x * x * x;
                break;
            case 4:
                y = 1 / x;
                break;
            default:
                y = 0;
        }
        System.out.println(y);
    }

}
