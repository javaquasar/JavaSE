package com.javaquasar.java.core.chapter_06_Methods.example;

import java.util.Arrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class InsertSort {
    public void Lol() {
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currElem = arr[i];
            int prevKey = i - 1;
            while (prevKey >= 0 && arr[prevKey] > currElem) {
                arr[prevKey + 1] = arr[prevKey];
                arr[prevKey] = currElem;
                prevKey--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
