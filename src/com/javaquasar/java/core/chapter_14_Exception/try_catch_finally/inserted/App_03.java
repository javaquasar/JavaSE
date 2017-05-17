package com.javaquasar.java.core.chapter_14_Exception.try_catch_finally.inserted;

/**
 * Created by Java Quasar on 16.05.17.
 */
// Вложенный try-catch-finally с исключением, которое ПЕРЕХВАТИТ ВНЕШНИЙ catch
public class App_03 {
	public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                if (true) {throw new Exception();}
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // НЕ заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
            } finally {                 
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // не заходим - выполнение НЕ в норме
        } catch (Exception e) {
            System.err.print(" 6");     // ЗАХОДИМ - есть подходящее исключение
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // заходим - выполнение УЖЕ в норме
    }
}

// >> 0 1 4 6 7 8

/* Мы НЕ заходим в ПЕРВУЮ catch-секцию (не печатаем «3»), но заходим в ВТОРУЮ catch-секцию (печатаем «6»), 
 * заходим в обе finally-секции (печатаем «4» и «7»), в ПЕРВОМ случае НЕ выполняем код ПОСЛЕ finally 
 * (не печатаем «5», так как исключение НЕ остановлено), во ВТОРОМ случае выполняем код после finally 
 * (печатаем «8», так как исключение остановлено).*/
