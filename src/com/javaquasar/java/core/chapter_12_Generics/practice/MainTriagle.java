package com.javaquasar.java.core.chapter_12_Generics.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Java Quasar on 16.05.17.
 */
class Triagle {
    double a, b, c;

    Triagle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double squareOfTriagle() {
        double square = 1.0 / 4.0 * Math.sqrt((a + b + c) * (b + c - a) * (a + c - b) * (a + b - c));
        return square;
    }

    @Override
    public String toString() {
        return "Triagle (square = " + squareOfTriagle() + ")";
    }
}

class SortForTriagle implements Comparator<Triagle> {
    @Override
    public int compare(Triagle o1, Triagle o2) {
        return -Double.compare(o1.squareOfTriagle(), o2.squareOfTriagle());
    }
}

public class MainTriagle {
    public static void main(String[] args) {

        List<Triagle> mainTriagle = Arrays.asList(
                new Triagle(2, 2, 3),
                new Triagle(6, 7, 8),
                new Triagle(4, 5, 6),
                new Triagle(9, 10, 10));
        Collections.sort(mainTriagle, new SortForTriagle());
        System.out.println(mainTriagle);
        Collections.sort(mainTriagle, new Comparator<Triagle>() {
            @Override
            public int compare(Triagle o1, Triagle o2) {
                return Double.compare(o1.squareOfTriagle(), o2.squareOfTriagle());
            }
        });
        System.out.println(mainTriagle);
    }
}
