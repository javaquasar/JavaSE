package com.javaquasar.java.core.chapter_15_Exception.finally_example;

/**
 * Created by Java Quasar on 16.05.17.
 */
/* Однако finally-секция не может «починить» try-блок завершившийся исключение 
 * (заметьте, «more» — не выводится в консоль)*/

/* Трюк с «if (true) {...}» требуется, так как иначе компилятор обнаруживает 
 * недостижимый код (последняя строка) и отказывается его компилировать*/

public class FinallyWithoutCatch {
	public static void main(String[] args) {
        try {
            System.err.println("try");
            //throw new RuntimeException();
            if (true) {throw new RuntimeException();}
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }
}


