package com.javaquasar.java.core.chapter_14_Exception.try_catch_finally;

// Есть исключение но нет подходящего catch
// Не заходим в catch, заходим в finally, не продолжаем после оператора — вылетаем с неперехваченным исключением
/**
 * Created by Java Quasar on 16.05.17.
 */
public class Try_Catch_Finally_03 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch(Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }
}

// >> 0 3
// >> RUNTIME ERROR: Exception in thread "main" java.lang.RuntimeException