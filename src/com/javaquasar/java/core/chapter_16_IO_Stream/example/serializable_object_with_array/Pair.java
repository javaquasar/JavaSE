package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable_object_with_array;

import java.io.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Pair implements Serializable {
	private static final long serialVersionUID = 6802552080830378203L;
	double x, y;

	public Pair(double x, double y) {
		this.x = x;
		this.y = y;
	}

}
