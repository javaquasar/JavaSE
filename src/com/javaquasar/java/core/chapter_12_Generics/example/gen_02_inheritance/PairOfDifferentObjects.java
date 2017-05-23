package com.javaquasar.java.core.chapter_12_Generics.example.gen_02_inheritance;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class PairOfDifferentObjects<T, E> {
    T first;
    E second;

    public PairOfDifferentObjects(T first, E second) {
        this.first = first;
        this.second = second;
    }

    public static void main(String[] args) {
        PairOfDifferentObjects<Integer, String> p = new PairOfDifferentObjects<Integer, String>(1000, "thousand");
        PairOfDifferentObjects<Integer, Integer> p1 = new PairOfDifferentObjects<Integer, Integer>(1, 2);
        //...
    }

}
