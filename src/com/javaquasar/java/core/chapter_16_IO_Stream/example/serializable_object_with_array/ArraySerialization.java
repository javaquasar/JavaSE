package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable_object_with_array;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ArraySerialization {

	public static void main(String[] args) {
		Pair[] points = { new Pair(1, 2), new Pair(3, 4), new Pair(5, 6) };
		ArrayOfPairs arrayOfPoints = new ArrayOfPairs(points);
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./file/16/array_serialization.dat"))) {
			out.writeObject(arrayOfPoints);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}