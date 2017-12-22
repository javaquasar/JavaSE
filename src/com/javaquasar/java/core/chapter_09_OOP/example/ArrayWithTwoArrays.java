package com.javaquasar.java.core.chapter_09_OOP.example;

public class ArrayWithTwoArrays extends AbstractArrayOfPoints {
	  private double[] ax = { };
	  private double[] ay = { };

	  @Override
	  public void setPoint(int i, double x, double y) {
	    if (i < count()) {
	      ax[i] = x;
	      ay[i] = y;
	    }
	  }

	  @Override
	  public double getX(int i) {
	    return ax[i];
	  }

	  @Override
	  public double getY(int i) {
	    return ay[i];
	  }

	  @Override
	  public int count() {
	    return ax.length; // Можно y.length, они одинаковые
	  }

	  @Override
	  public void addPoint(double x, double y) {
	    double[] ax1 = new double[ax.length + 1];
	    System.arraycopy(ax, 0, ax1, 0, ax.length);
	    ax1[ax.length] = x;
	    ax = ax1;
	    double[] ay1 = new double[ay.length + 1];
	    System.arraycopy(ay, 0, ay1, 0, ay.length);
	    ay1[ay.length] = y;
	    ay = ay1;
	  }

	  @Override
	  public void removeLast() {
	    if (count() == 0)
	      return;
	    double[] ax1 = new double[ax.length - 1];
	    System.arraycopy(ax, 0, ax1, 0, ax1.length);
	    ax = ax1;
	    double[] ay1 = new double[ay.length - 1];
	    System.arraycopy(ay, 0, ay1, 0, ay1.length);
	    ay = ay1;
	  }

	  public static void main(String[] args) {
	    new ArrayWithTwoArrays().test();
	  }
	}
