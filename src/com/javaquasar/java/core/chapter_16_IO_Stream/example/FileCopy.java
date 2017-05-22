package com.javaquasar.java.core.chapter_16_IO_Stream.example;

import java.io.*;

public class FileCopy {

	public static void copy(String inFile, String outFile) {
		byte[] buffer = new byte[1024]; // Буфер байтів
		try (InputStream input = new FileInputStream(inFile); OutputStream output = new FileOutputStream(outFile)) {
			int bytesRead;
			while ((bytesRead = input.read(buffer)) >= 0) {
				output.write(buffer, 0, bytesRead);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		copy("bin/lesson305/FileCopy.class", "FileCopy.copy");
	}

}