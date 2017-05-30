package com.javaquasar.java.core.chapter_05_Loops.for_multi_loops;

/**
 * Created by Java Quasar on 30.05.17.
 */
public class TestLinks {
    public static void main(String[] args) {
        // outer - это метка, к которой мы можем перепрыгнуть находясь в циклах
        for (int i = 0; i < 2; i++) {
            outer:  for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(k == 2) {
                        // Если k = 2, то цикл по "k" прервется в этой точке и прервет
                        // остальные циклы до метки outer включительно
                        break outer;
                    }
                    System.out.print("i = " + i + " ");
                    System.out.print("j = " + j + " ");
                    System.out.println("k = " + k);
                }
            }
        }

        System.out.println("----------------------------------");

        outer: for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(k == 2) {
                        // Если k = 2, то цикл по "k" прервется в этой точке и работа возобновиться с цикла,
                        // на котором стоит метка outer
                        continue outer;
                    }
                    System.out.print("i = " + i + " ");
                    System.out.print("j = " + j + " ");
                    System.out.println("k = " + k);
                }
            }
        }

        System.out.println("----------------------------------");

        outer: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    System.out.println();
                    continue outer;
                }
                System.out.print(" " + (i * j));
            }
        }
    }
}
