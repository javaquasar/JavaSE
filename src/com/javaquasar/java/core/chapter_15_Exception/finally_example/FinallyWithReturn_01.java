package com.javaquasar.java.core.chapter_15_Exception.finally_example;

/**
 * Created by Java Quasar on 16.05.17.
 */
/* И finally-секция не может «предотвратить» выход из метода, 
 * если try-блок вызвал return («more» — не выводится в консоль)*/

public class FinallyWithReturn_01 {
	public static void main(String[] args) {
        try {
            System.err.println("try");
            if (true) {return;}
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }
}
