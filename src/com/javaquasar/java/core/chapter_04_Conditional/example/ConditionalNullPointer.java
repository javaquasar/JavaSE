package com.javaquasar.java.core.chapter_04_Conditional.example;

/**
 * Created by Java Quasar on 03.11.17.
 */
public class ConditionalNullPointer {
    public static void main(String[] args) {
        boolean isQuestion = false;
        System.out.println(isQuestion ? 42 :
                isQuestion ? 42 : null);
    }
}
