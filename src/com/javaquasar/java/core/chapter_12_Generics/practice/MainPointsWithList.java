package com.javaquasar.java.core.chapter_12_Generics.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class MainPointsWithList {
    public static void main(String[] args) {
        ListWithDouble listWithDouble = new ListWithDouble();
        listWithDouble.test();
    }
}

abstract class AbstractArrayOfPoints {
    // Запись новых координат точки:
    public abstract void setPoint(int i, double x, double y);

    // Получение X точки i:
    public abstract double getX(int i);

    // Получение Y точки i:
    public abstract double getY(int i);

    // Получение количества точек:
    public abstract int count();

    // Добавление точки в конец массива:
    public abstract void addPoint(double x, double y);

    // Удаление последней точки:
    public abstract void removeLast();

    // Сортировка по значениям X:
    public abstract void sortByX();

    public abstract void sortByY();
}

class ListWithDouble extends AbstractArrayOfPoints {
    List<Double> mainList = new ArrayList<>();

    @Override
    public void setPoint(int i, double x, double y) {
        if (i < 0 || i > count()) {
            throw new IndexOutOfBoundsException();
        } else {
            mainList.set(i * 2, x);
            mainList.set(i * 2 + 1, y);
        }

    }

    @Override
    public double getX(int i) {
        double xInList;
        if (i < count() || i >= 0) {
            xInList = mainList.get(i * 2);
            return xInList;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public double getY(int i) {
        double yInList;
        if (i < count() || i >= 0) {
            yInList = mainList.get((i * 2) + 1);
            return yInList;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int count() {
        return mainList.size() / 2;
    }

    @Override
    public void addPoint(double x, double y) {
        mainList.add(x);
        mainList.add(y);
    }

    @Override
    public void removeLast() {
        mainList.remove(mainList.size() - 1);
        mainList.remove(mainList.size() - 2);
    }

    @Override
    public void sortByX() {
        for (int i = 0; i < mainList.size(); i++) {
            for (int j = mainList.size() - 1; j > 1; j -= 2) {
                if (mainList.get(j - 1) < mainList.get(j - 3)) {
                    double tmp = mainList.get(j - 1);
                    mainList.set(j - 1, mainList.get(j - 3));
                    mainList.set(j - 3, tmp);
                    double tmp2 = mainList.get(j);
                    mainList.set(j, mainList.get(j - 2));
                    mainList.set(j - 2, tmp2);
                }
            }
        }

    }

    @Override
    public void sortByY() {
        for (int i = 0; i < mainList.size(); i++) {
            for (int j = mainList.size() - 1; j > 1; j -= 2) {
                if (mainList.get(j) < mainList.get(j - 2)) {
                    double tmp = mainList.get(j - 1);
                    mainList.set(j - 1, mainList.get(j - 3));
                    mainList.set(j - 3, tmp);
                    double tmp2 = mainList.get(j);
                    mainList.set(j, mainList.get(j - 2));
                    mainList.set(j - 2, tmp2);
                }
            }
        }
    }

    public void printMyList() {
        for (int i = 0; i < mainList.size() - 1; i += 2) {
            System.out.println("[" + mainList.get(i) + ","
                    + mainList.get(i + 1) + "]");
        }
    }

    public void test() {
        addPoint(4, 1);
        addPoint(3, 2);
        addPoint(2, 3);
        addPoint(1, 4);
        // listWithDouble.sortByY();
        sortByX();
        printMyList();
        System.out.println("--------");
        sortByY();
        printMyList();
        System.out.println("--------");
        removeLast();
        removeLast();
        printMyList();
    }
}
