package com.javaquasar.java.core.chapter_05_Loops.for_multi_loops;

/**
 * Created by Java Quasar on 30.05.17.
 */
public class TestMultiLoops {
    public static void main(String[] args) {
        // циклы можно владывать друг в друга
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("i = " + i + " ");
                System.out.println("j = " + j);
            }
        }

        System.out.println("----------------------------------");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                if(j == 2) {
                    // Если j = 2, то цикл по j прервется в этой точке
                    break;
                }
                System.out.print("i = " + i + " ");
                System.out.println("j = " + j);
            }
        }

        System.out.println("----------------------------------");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                if(j == 2) {
                    // Если j = 2, то цикл по j прервется в этой точке на начнет работу со следующей итерации
                    continue;
                }
                System.out.print("i = " + i + " ");
                System.out.println("j = " + j);
            }
        }

        System.out.println("----------------------------------");
    }
}
