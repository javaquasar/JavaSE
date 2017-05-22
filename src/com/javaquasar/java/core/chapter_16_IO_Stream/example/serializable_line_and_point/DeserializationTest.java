package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable_line_and_point;

import java.io.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class DeserializationTest {

	public static void main(String[] args) throws ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./file/16/line_and_point_serialization.dat"))) {
			Line line = (Line) in.readObject();
			System.out.println(line.getFirst().getX() + " " + line.getFirst().getY() + " " + line.getSecond().getX() + " " + line.getSecond().getY());
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
	}

}
