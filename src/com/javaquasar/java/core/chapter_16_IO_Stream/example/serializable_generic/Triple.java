package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable_generic;

import java.io.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
class Triple<T> implements Serializable {
	private static final long serialVersionUID = 7512336951571111736L;
	T x, y, z;

	Triple(T x, T y, T z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
