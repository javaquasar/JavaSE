package com.javaquasar.java.core.chapter_16_IO_Stream.example;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class FileTest2 {

	void readWrite() {
		try (Scanner scanner = new Scanner(new FileReader("data.txt"))) {
			try (PrintWriter pw = new PrintWriter("results.txt")) {
				pw.println(scanner.nextInt() + scanner.nextDouble());
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileTest().readWrite();
	}

}