package com.javaquasar.java.core.chapter_16_IO_Stream.example;

import java.io.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TextFileCopy {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Нужны аргументы!");
			return;
		}
		try (BufferedReader in = new BufferedReader(new FileReader(args[0]));
			 PrintWriter out = new PrintWriter(new FileWriter(args[1]))) {
			String line;
			while ((line = in.readLine()) != null) {
				out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
