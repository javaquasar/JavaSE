package com.javaquasar.java.core.chapter_01_Start.input;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ScannerTest_1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();//считываем целое число
        byte b = in.nextByte();//считываем байтовое число
        String c = in.nextLine();//считываем одну строку целиком
        double d = in.nextDouble();//считываем вещественное число
        long  e = in.nextLong();//считываем длинное целое число
        short f = in.nextShort();//считываем короткое целое число
        String s = in.next();//считываем строку до первого пробела
    }
}
