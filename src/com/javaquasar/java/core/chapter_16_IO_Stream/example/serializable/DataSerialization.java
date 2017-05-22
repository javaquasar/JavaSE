package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable;

import java.io.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class DataSerialization {

	public static void main(String[] args) {
		Continent c = new Continent("Европа",
				new Country("Украина", 603700, 46314736),
				new Country("Франция", 547030, 61875822),
				new Country("Германия", 357022, 82310000));

		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("./file/16/serialized_countries.dat"))) {
			out.writeObject(c);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
