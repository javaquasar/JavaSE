package com.javaquasar.java.core.chapter_12_Generics.practice;

import java.util.Arrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
class Circle implements Comparable<Circle>
{
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public int compareTo(Circle o) {
        return Integer.compare(radius, o.radius );
    }

    @Override
    public String toString() {
        return "Circle (" +
                "radius=" + radius +
                ')';
    }
}
public class MainCircle {
    public static void main(String[] args) {
       Circle[] testArray = {new Circle(10),new Circle(15),new Circle(1)};
       Arrays.sort(testArray);
       System.out.println(Arrays.asList(testArray));
    }
}
