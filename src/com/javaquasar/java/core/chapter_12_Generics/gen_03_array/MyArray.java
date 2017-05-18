package com.javaquasar.java.core.chapter_12_Generics.gen_03_array;

/**
 * Created by Java Quasar on 16.05.17.
 */

/*
Нельзя создавать объекты и массивы обобщенных типов:
T arr = new T[10]; // ошибка!

В нашем примере эту проблему можно решить с помощью ссылок на класс Object.
Альтернативная реализация может быть следующей:
 */
public class MyArray<T> {
    private Object[] arr;

    public MyArray(T[] arr) {
        this.arr = arr;
    }

    public MyArray(int size) {
        arr = new Object[size];
    }

    public int size() {
        return arr.length;
    }

    public T get(int i) {
        return (T)arr[i];
    }

    public void set(int i, T t) {
        arr[i] = t;
    }

    public void printAll() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArray<String> a = new MyArray<String>(new String[]{"1", "2"});
        String s = a.get(a.size() - 1);
        System.out.println(s);     // 2
        a.set(1, "New");
        a.printAll();              // 1 New
        MyArray<Double> b = new MyArray<Double>(3);
        b.set(0, 1.0);
        b.set(1, 2.0);
        b.set(2, 4.0);
        b.printAll();
    }


}
