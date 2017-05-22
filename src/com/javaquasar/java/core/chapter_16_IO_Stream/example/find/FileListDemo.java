package com.javaquasar.java.core.chapter_16_IO_Stream.example.find;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class FileListDemo {

	public static void main(String[] args) {
		Path dir = Paths.get("/Users/artur/Desktop/");
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir)) {
			for (Path p : ds) {
				System.out.println(p.getFileName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}