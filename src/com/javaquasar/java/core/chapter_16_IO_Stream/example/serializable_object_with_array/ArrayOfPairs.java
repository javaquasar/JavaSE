package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable_object_with_array;

import java.io.Serializable;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ArrayOfPairs implements Serializable {
	private static final long serialVersionUID = 5308689750632711432L;
	Pair[] pairs;

	public ArrayOfPairs(Pair[] pairs) {
		this.pairs = pairs;
	}

}
