package com.javaquasar.java.core.chapter_09_OOP.example;

import java.util.Arrays;

public class SomeCloneableClass implements Cloneable {
	  double x, y;
	  int[] a;
	  
	  public SomeCloneableClass(double x, double y, int[] a) {
	    super();
	    this.x = x;
	    this.y = y;
	    this.a = a;
	  }

	  @Override
	  protected SomeCloneableClass clone() throws CloneNotSupportedException {
	    SomeCloneableClass scc = (SomeCloneableClass) super.clone(); // копируем x и y
	    scc.a = a.clone(); // теперь два объекта работают с различными массивами
	    return scc;
	  }

	  @Override
	  public String toString() {
	    return " x=" + x + " y=" + y + " a=" + Arrays.toString(a);
	  }

	  public static void main(String[] args) throws CloneNotSupportedException {
	    SomeCloneableClass scc1 = new SomeCloneableClass(0.1, 0.2, new int[] { 1, 2, 3 });
	    SomeCloneableClass scc2 = scc1.clone();
	    scc2.a[2] = 4;
	    System.out.println("scc1:" + scc1);
	    System.out.println("scc2:" + scc2);
	  }

	}
