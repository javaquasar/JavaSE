package com.javaquasar.java.core.chapter_14_Exception.finally_example.failed;

/**
 * Created by Java Quasar on 16.05.17.
 */
// finally-секция НЕ вызывается только если мы «прибили» JVM

public class FinallySystemExit {
	public static void main(String[] args) {
        try {
            System.exit(42); 
            Runtime.getRuntime().exit(42); // это синоним System.exit(42);
            Runtime.getRuntime().halt(42); // рубит все
        } finally {
            System.err.println("finally");
        }
    }
}
