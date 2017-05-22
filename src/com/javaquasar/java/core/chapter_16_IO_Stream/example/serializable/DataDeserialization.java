package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable;

import java.io.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class DataDeserialization {

	public static void main(String[] args) throws ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./file/16/serialized_countries.dat"))) {
			Continent continent = (Continent) in.readObject();
			for (Country c : continent.getCountries())
				System.out.println(c.getName() + " " + c.getArea() + " " + c.getPopulation());
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
	}

}
