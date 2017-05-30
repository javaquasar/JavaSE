package com.javaquasar.java.core.chapter_05_Loops.for_loops;



/**
 * Created by Java Quasar on 30.05.17.
 */
public class TestFor {
    public static void main(String[] args) {

        // цикл без фигурных скобок, будет повторять только одну строку кода идущую после него (до первой ";")
        for (int i = 0; i < 5; i++)
            System.out.println("i = " + i); System.out.println("string");

        System.out.println("----------------------------------");

        // У переменных объявленныъ в фигурных скобках время жизни находиться в пределах цикла
        for (int i = 0; i < 0; i++) {
            System.out.println("i = " + i);
            System.out.println("string");
        }

        System.out.println("----------------------------------");

        // Можно объявить несколько переменных, но они должны быть одного типа
        for (int i = 0, j = 0; i < 5 || j < 8; i++, j+=2) {
            System.out.println("i = " + i);
            System.out.println("j = " + j);
        }

        System.out.println("----------------------------------");

        // Один из способов создать бесконечный цикл
        /*for (;;) {
            System.out.println("Бесконечный цикл");
        }*/

    }
}
