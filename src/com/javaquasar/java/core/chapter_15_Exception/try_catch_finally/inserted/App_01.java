package com.javaquasar.java.core.chapter_15_Exception.try_catch_finally.inserted;

/**
 * Created by Java Quasar on 16.05.17.
 */
// Вложенный try-catch-finally без исключения
public class App_01 {
	public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                // НИЧЕГО
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // НЕ заходим - нет исключения
            } finally {                 
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // заходим - выполнение в норме
        } catch (Exception e) {
            System.err.print(" 6");     // НЕ заходим - нет исключения
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // заходим - выполнение в норме
    }
}

// Мы НЕ заходим в обе catch-секции (нет исключения), заходим в обе finally-секции и выполняем обе строки ПОСЛЕ finally.

// >> 0 1 2 4 5 7 8