package com.javaquasar.java.core.chapter_08_Look_at_Classes_and_Objects.example;

/**
 * Created by Java Quasar on 16.05.17.
 */
class MyClass implements Cloneable {

    public MyClass() {

    }

    @Override
    public MyClass clone() throws CloneNotSupportedException {
        return new MyClass();
    }
}
