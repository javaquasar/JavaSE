package com.javaquasar.java.core.chapter_12_Generics.practice;

import java.util.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
class Rectangle {
    double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public String toString() {
        return "[" + width + ", " + height + ", area = " + area() + "]";
    }
}

class RectangleComparator implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        return Double.compare(o1.area(), o2.area());
    }

}

public class Figure {
    public static void main(String[] args) {

        Rectangle[] a = {new Rectangle(2, 7), new Rectangle(5, 3), new Rectangle(3, 4)};
        Arrays.sort(a, new Comparator<Rectangle>() {
            @Override
            public int compare(Rectangle o1, Rectangle o2) {
                return Double.compare(o1.area(), o2.area());
            }
        });
        System.out.println(Arrays.asList(a));
        List<Rectangle> rectangleList = new ArrayList<>();
        rectangleList.add(new Rectangle(2, 7));
        rectangleList.add(new Rectangle(5, 3));
        rectangleList.add(new Rectangle(3, 4));
//        Collections.sort(rectangleList,new Comparator<Rectangle>() {
//            @Override
//            public int compare(Rectangle o1, Rectangle o2) {
//                return Double.compare(o1.area(),o2.area());
//            }
//        });
        Collections.sort(rectangleList, new RectangleComparator());
        System.out.println(rectangleList);

    }
}
