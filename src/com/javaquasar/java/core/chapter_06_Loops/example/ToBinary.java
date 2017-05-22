package com.javaquasar.java.core.chapter_06_Loops.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
@SuppressWarnings("resource")
public class ToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte b = scanner.nextByte();
        for (int i = 7; i >= 0; i--) {
            System.out.print((byte) (1 & (b >> i)));
        }
    }

}
