package com.javaquasar.java.core.chapter_15_Exception.try_catch_finally;

// Нет исключения

// Не заходим в catch, заходим в finally, продолжаем после оператора
/**
 * Created by Java Quasar on 16.05.17.
 */
public class Try_Catch_Finally_01 {
	public static void main(String[] args) {
        try {
            System.err.print(" 0");
            // nothing
            System.err.print(" 1");
        } catch(Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }
}

// >> 0 1 3 4
