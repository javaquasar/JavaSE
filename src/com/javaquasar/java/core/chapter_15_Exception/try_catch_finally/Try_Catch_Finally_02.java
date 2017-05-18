package com.javaquasar.java.core.chapter_15_Exception.try_catch_finally;

// Есть исключение и есть подходящий catch
// Заходим в catch, заходим в finally, продолжаем после оператора
/**
 * Created by Java Quasar on 16.05.17.
 */
public class Try_Catch_Finally_02 {
	public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new Error();}
            System.err.print(" 1");
        } catch(Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }
}

// >> 0 2 3 4
