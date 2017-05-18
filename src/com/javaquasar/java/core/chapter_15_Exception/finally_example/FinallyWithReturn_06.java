package com.javaquasar.java.core.chapter_15_Exception.finally_example;

/**
 * Created by Java Quasar on 16.05.17.
 */
/* Однако finally-секция может «перебить» throw/return при помощи другого throw/returnÎ*/

public class FinallyWithReturn_06 {
	public static void main(String[] args) {
        System.err.println(f());
    }
    @SuppressWarnings("finally")
	public static int f() {
        try {
            throw new Error();
        } finally {
            throw new RuntimeException();
        }
    }
}
