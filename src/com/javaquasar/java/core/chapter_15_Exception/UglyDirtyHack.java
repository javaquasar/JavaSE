package com.javaquasar.java.core.chapter_15_Exception;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class UglyDirtyHack {

	public static void main(String[] args) {
        getUnsafe().throwException(new IOException("This is checked exception"));
    }

    public static Unsafe getUnsafe() {
        Unsafe unsafe = null;
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (ReflectiveOperationException e) {
            System.out.println("Who cares");
        }
        return unsafe;
    }

    public static void t() throws IOException {

	    throw new IOException("fdgdfghfd dfgdfgdfd");
    }
}
