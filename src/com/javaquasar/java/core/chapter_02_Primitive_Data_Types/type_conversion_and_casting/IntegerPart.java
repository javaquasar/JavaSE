package com.javaquasar.java.core.chapter_02_Primitive_Data_Types.type_conversion_and_casting;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class IntegerPart {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int n = (int) x;
        System.out.println(n);
    }

}
