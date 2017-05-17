package com.javaquasar.java.core.chapter_10_Generics.gen_02_inheritance;

/**
 * Created by Java Quasar on 16.05.17.
 */

/*
Можно ограничить использование типа параметра функции определенными производными классами, например, List<? super String>.
Тогда использование списка List<Integer> невозможно.

Приведем пример создания обобщенного класса, который хранит массив элементов определенного типа:
 */
public class MyArray<T> {
    // Нельзя создавать объекты и массивы обобщенных типов:
    // T arr = new T[10]; // ошибка!
    private T[] arr;

    public MyArray(T[] arr) {
        this.arr = arr;
    }

    public int size() {
        return arr.length;
    }

    public T get(int i) {
        return arr[i];
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
    }

}
