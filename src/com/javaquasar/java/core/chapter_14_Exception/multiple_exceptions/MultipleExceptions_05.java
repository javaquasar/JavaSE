package com.javaquasar.java.core.chapter_14_Exception.multiple_exceptions;

/**
 * Created by Java Quasar on 16.05.17.
 */
/* или так (ставим catch по предку и точно перехватываем)*/

public class MultipleExceptions_05 {
	public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Throwable e) {
            // ...
        }
    }
}
