package com.javaquasar.java.core.chapter_16_IO_Stream.example;

import java.io.*;
import java.util.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class DataReadDemo {

	public static void main(String[] args) {
		try (DataInputStream in = new DataInputStream(new FileInputStream("data.dat"))) {
			double x = in.readDouble();
			String s = in.readUTF();
			List<Integer> list = new ArrayList<>();
			try {
				while (true) {
					int k = in.readInt();
					list.add(k);
				}
			} catch (Exception e) {
			}
			System.out.println(x);
			System.out.println(s);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}