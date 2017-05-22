package com.javaquasar.java.core.chapter_16_IO_Stream.example;

import java.io.*;
import java.util.zip.*;

public class ZipExtractor {

	public static void main(String[] args) {
		try (ZipInputStream zIn = new ZipInputStream(new FileInputStream("Source.zip"))) {
			ZipEntry entry;
			byte[] buffer = new byte[1024];
			while ((entry = zIn.getNextEntry()) != null) {
				int bytesRead;
				System.out.println("------------" + entry.getName() + "------------");
				while ((bytesRead = zIn.read(buffer)) >= 0) {
					System.out.write(buffer, 0, bytesRead);
				}
				zIn.closeEntry();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
