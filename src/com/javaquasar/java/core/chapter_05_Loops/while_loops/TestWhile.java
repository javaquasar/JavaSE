package com.javaquasar.java.core.chapter_05_Loops.while_loops;

/**
 * Created by Java Quasar on 30.05.17.
 */
public class TestWhile {
    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("----------------------------------");

        // Использование цикла while
        // Этот код выполняет аналогичную работу цикла, указанного выше
        int i = 0;
        while (i < 2) {
            System.out.println("i = " + i);
            i++;
        }


        // Цикл do while сначала выполняет код указанный в фигурных скобках и только потом проверяет условие
        int j = 0;
        do {
            System.out.println("do while");
            j++;
        } while (j > 10);

        // Способ написать бесконечный цикл
        /*while(true) {

        }*/

        // цикл без фигурных скобок, будет повторять только одну строку кода идущую после него (до первой ";")
        int k = 0;
        while (k < 2)
            System.out.println("");
    }
}
