package com.javaquasar.java.core.chapter_16_IO_Stream.example.find;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class FindAllFiles {

	private static class Finder extends SimpleFileVisitor<Path> {

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				throws IOException {
			System.out.println(file);
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult preVisitDirectory(Path dir,
				BasicFileAttributes attrs) throws IOException {
			System.out.println("----------------" + dir + "----------------");
			return FileVisitResult.CONTINUE;
		}

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String dirName = new Scanner(System.in).nextLine();
		try {
			Files.walkFileTree(Paths.get(dirName), new Finder()); // Текущий
																	// каталог
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
