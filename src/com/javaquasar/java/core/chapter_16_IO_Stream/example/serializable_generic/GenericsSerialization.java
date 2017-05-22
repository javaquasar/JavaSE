package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable_generic;

import java.io.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class GenericsSerialization {

	public static void main(String[] args) {
		Triple<Integer> t1 = new Triple<>(1, 2, 3);
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./file/16/serialized_generic_integers.dat"))) {
			out.writeObject(t1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
		Triple<String> t2 = new Triple<>("A", "B", "C");
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./file/16/serialized_generic_strings.dat"))) {
			out.writeObject(t2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
	}

}
