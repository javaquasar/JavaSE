package com.javaquasar.java.core.chapter_18_XML.serialization;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Point implements java.io.Serializable {
	private static final long serialVersionUID = -3566722853756147165L;
	private double x, y;

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

}
