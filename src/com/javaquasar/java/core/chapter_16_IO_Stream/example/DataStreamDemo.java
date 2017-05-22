package com.javaquasar.java.core.chapter_16_IO_Stream.example;

import java.io.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class DataStreamDemo {

	public static void main(String[] args) {
		double x = 4.5;
		String s = "all";
		int[] a = { 1, 2, 3 };
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream("data.dat"))) {
			out.writeDouble(x);
			out.writeUTF(s);
			for (int k : a)
				out.writeInt(k);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

