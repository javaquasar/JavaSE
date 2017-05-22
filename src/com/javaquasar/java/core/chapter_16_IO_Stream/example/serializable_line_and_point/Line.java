package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable_line_and_point;

import java.io.Serializable;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Line implements Serializable {
	private static final long serialVersionUID = -4909779210010719389L;
	private Point first = new Point(), second = new Point();

	public void setFirst(Point first) {
		this.first = first;
	}

	public Point getFirst() {
		return first;
	}

	public Point getSecond() {
		return second;
	}

	public void setSecond(Point second) {
		this.second = second;
	}

}
