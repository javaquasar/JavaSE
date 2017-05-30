package com.javaquasar.java.core.chapter_05_Loops.while_multi_loops;

/**
 * Created by Java Quasar on 30.05.17.
 */
public class TestLinks {
    public static void main(String[] args) {
        // outer - это метка, к которой мы можем перепрыгнуть находясь в циклах
        int i = 0;
        while (i < 2) {
            int j = 0;
            outer: while (j < 5) {
                int k = 0;
                while (k < 5) {
                    if(k == 2) {
                        // Если k = 2, то цикл по "k" прервется в этой точке и прервет
                        // остальные циклы до метки outer включительно
                        //break outer;

                        // Если k = 2, то цикл по "k" прервется в этой точке и работа возобновиться с цикла,
                        // на котором стоит метка outer
                        // continue outer; будет бесконечный цикл
                    }
                    System.out.print("i = " + i + " ");
                    System.out.print("j = " + j + " ");
                    System.out.println("k = " + k);
                    k++;
                }
                j++;
            }
            i++;
        }

        System.out.println("----------------------------------");

    }
}
