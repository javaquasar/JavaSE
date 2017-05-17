package com.javaquasar.java.core.chapter_14_Exception.try_catch_finally.inserted;

/**
 * Created by Java Quasar on 16.05.17.
 */
// Вложенный try-catch-finally с исключением, которое ПЕРЕХВАТИТ ВНУТРЕННИЙ catch
public class App_02 {
	public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                if (true) {throw new RuntimeException();}
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // ЗАХОДИМ - есть исключение
            } finally {                 
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // заходим - выполнение УЖЕ в норме
        } catch (Exception e) {
            System.err.print(" 6");     // не заходим - нет исключения, УЖЕ перехвачено
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // заходим - выполнение УЖЕ в норме
    }
}

/* Мы заходим в ПЕРВУЮ catch-секцию (печатаем «3»), но НЕ заходим во ВТОРУЮ catch-секцию 
* (НЕ печатаем «6», так как исключение УЖЕ перехвачено первым catch), заходим в обе finally-секции 
* (печатаем «4» и «7»), в обоих случаях выполняем код после finally (печатаем «5»и «8», так как 
* исключение остановлено еще первым catch). */

// >> 0 1 3 4 5 7 8