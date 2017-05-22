package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable_object_with_array;

import java.io.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ArrayDeserialization {

	public static void main(String[] args) throws ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./file/16/array_serialization.dat"))) {
			ArrayOfPairs arrayOfPairs = (ArrayOfPairs) in.readObject();
			for (Pair p : arrayOfPairs.pairs)
				System.out.println(p.x + " " + p.y);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}