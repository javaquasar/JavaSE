package com.javaquasar.java.core.chapter_01_Start.input;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ScannerNumber {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();//считываем целое число a
        int b = in.nextInt();//считываем целое число b
        System.out.print(a+b);//выводим сумму a+b
    }
}
