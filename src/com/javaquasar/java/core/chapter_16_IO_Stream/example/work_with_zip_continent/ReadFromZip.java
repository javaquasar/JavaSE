package com.javaquasar.java.core.chapter_16_IO_Stream.example.work_with_zip_continent;

import java.io.*;
import java.util.zip.*;

public class ReadFromZip {

	public static void main(String[] args) {
		try (ZipInputStream zIn = new ZipInputStream(new FileInputStream("./file/16/continent.zip"));
			 DataInputStream in = new DataInputStream(zIn)) {
			ZipEntry entry;
			while ((entry = zIn.getNextEntry()) != null) {
				System.out.println("Страна: " + entry.getName());
				System.out.println("Территория: " + in.readDouble());
				System.out.println("Население: " + in.readInt());
				System.out.println();
				zIn.closeEntry();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}