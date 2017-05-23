package com.javaquasar.java.core.chapter_12_Generics.practice;

import java.util.Arrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
class SwapClass {

    public static <T> void swapElements(T[] array, int firstIndex, int secondIndex) throws SwapException {
        if (firstIndex < 0 || firstIndex > array.length - 1 || secondIndex < 0 || secondIndex > array.length - 1) {
            throw new SwapException("Swap exception !");
        }
        T tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }

    static class SwapException extends Exception {
        public SwapException(String s) {
            super(s);
        }
    }
}

public class MainException {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] string = {"a", "b", "c", "d", "e", "f"};
        try {
            SwapClass.swapElements(integers, 0, 1);
        } catch (SwapClass.SwapException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.asList(integers));
        try {
            SwapClass.swapElements(string, 0, 11);
        } catch (SwapClass.SwapException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.asList(string));
    }

}
