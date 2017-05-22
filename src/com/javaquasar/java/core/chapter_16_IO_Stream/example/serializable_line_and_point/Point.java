package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable_line_and_point;

import java.io.Serializable;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Point implements Serializable {
	private static final long serialVersionUID = -3861862668546826739L;
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
