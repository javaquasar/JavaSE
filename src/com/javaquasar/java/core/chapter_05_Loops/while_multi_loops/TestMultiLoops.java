package com.javaquasar.java.core.chapter_05_Loops.while_multi_loops;

/**
 * Created by Java Quasar on 30.05.17.
 */
public class TestMultiLoops {
    public static void main(String[] args) {
        // циклы можно владывать друг в друга
        // в таком исполнении циклы for  выглядят более компактно
        int i = 0;
        while (i < 2) {
            int j = 0;
            while (j < 2) {
                System.out.print("i = " + i + " ");
                System.out.println("j = " + j);
                j++;
            }
            i++;
        }
    }
}
