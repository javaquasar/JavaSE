package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable_generic;

import java.io.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class GenericsDeserialization {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./file/16/serialized_generic_integers.dat"))) {
			Triple<Integer> t1 = (Triple<Integer>) in.readObject();
			System.out.printf("%d %d %d%n", t1.x, t1.y, t1.z);
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./file/16/serialized_generic_strings.dat"))) {
			Triple<String> t2 = (Triple<String>) in.readObject();
			System.out.printf("%s %s %s%n", t2.x, t2.y, t2.z);
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
	}

}
