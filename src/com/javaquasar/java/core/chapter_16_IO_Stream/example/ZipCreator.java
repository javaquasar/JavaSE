package com.javaquasar.java.core.chapter_16_IO_Stream.example;

import java.io.*;
import java.util.zip.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ZipCreator {

	public static void main(String[] args) {
		try (ZipOutputStream zOut = new ZipOutputStream(new FileOutputStream("Source.zip"))) {
			ZipEntry zipEntry = new ZipEntry("src/lesson12/ZipCreator.java");
			zOut.putNextEntry(zipEntry);
			try (FileInputStream in = new FileInputStream("src/lesson12/ZipCreator.java")) {
				byte[] bytes = new byte[1024];
				int length;
				while ((length = in.read(bytes)) >= 0) {
					zOut.write(bytes, 0, length);
				}
			}
			zOut.closeEntry();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
