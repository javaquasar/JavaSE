package com.javaquasar.java.core.chapter_31_Java_8.example;

public interface Function {
    default double f(double x) {
        return x * x;
    }
}
