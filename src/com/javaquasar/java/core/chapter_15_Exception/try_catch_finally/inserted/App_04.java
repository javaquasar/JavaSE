package com.javaquasar.java.core.chapter_15_Exception.try_catch_finally.inserted;

/**
 * Created by Java Quasar on 16.05.17.
 */
// Вложенный try-catch-finally с исключением, которое НИКТО НЕ ПЕРЕХВАТИТ
public class App_04 {
	public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                if (true) {throw new Error();}
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // НЕ заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
            } finally {                 
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // НЕ заходим - выполнение НЕ в норме
        } catch (Exception e) {
            System.err.print(" 6");     // не заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // не заходим - выполнение НЕ в норме
    }
}

// >> 0 1 4 7
// >> RUNTIME EXCEPTION: Exception in thread "main" java.lang.Error

/* Мы НЕ заходим в ОБЕ catch-секции (не печатаем «3» и «6»), заходим в обе finally-секции (печатаем «4» и «7») 
 * и в обоих случаях НЕ выполняем код ПОСЛЕ finally (не печатаем «5» и «8», так как исключение НЕ остановлено), 
 * выполнение метода прерывается по исключению.*/
 