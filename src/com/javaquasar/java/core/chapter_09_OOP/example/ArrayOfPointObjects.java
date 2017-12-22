package com.javaquasar.java.core.chapter_09_OOP.example;

public class ArrayOfPointObjects extends AbstractArrayOfPoints {

	  private Point[] p = { };

	  @Override
	  public void setPoint(int i, double x, double y) {
	    if (i < count()) {
	      p[i].setPoint(x, y);
	    }
	  }

	  @Override
	  public double getX(int i) {
	    return p[i].getX();
	  }

	  @Override
	  public double getY(int i) {
	    return p[i].getY();
	  }

	  @Override
	  public int count() {
	    return p.length;
	  }

	  @Override
	  public void addPoint(double x, double y) {
	    // Создаем массив, больший на один элемент:
	    Point[] p1 = new Point[p.length + 1];
	    // Копируем все элементы:
	    System.arraycopy(p, 0, p1, 0, p.length);
	    // Записываем новую точку в последний элемент:
	    p1[p.length] = new Point(x, y);
	    p = p1; // Теперь p указывает на новый массив
	  }

	  @Override
	  public void removeLast() {
	    if (p.length == 0)
	      return; // Массив уже пустой
	    // Создаем массив, меньший на один элемент:
	    Point[] p1 = new Point[p.length - 1];
	    // Копируем все элементы, кроме последнего:
	    System.arraycopy(p, 0, p1, 0, p1.length);
	    p = p1; // Теперь p указывает на новый массив
	  }

	  public static void main(String[] args) {
	    // Можно создать безымянный объект:
	    new ArrayOfPointObjects().test();
	  }
	}