package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable_line_and_point;

import java.io.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SerializationTest {

	public static void main(String[] args) {
		Line line = new Line();
		line.getFirst().setX(1);
		line.getFirst().setY(2);
		line.getSecond().setX(3);
		line.getSecond().setY(4);
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./file/16/line_and_point_serialization.dat"))) {
			out.writeObject(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
	}

}
