package com.javaquasar.java.core.chapter_16_IO_Stream.example.find;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class FindWithNIO {

	private static class Finder extends SimpleFileVisitor<Path> {
		private int len;

		Finder(int len) {
			this.len = len;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				throws IOException {
			if (Files.size(file) >= len)
				System.out.println(file + "   " + Files.size(file));
			return FileVisitResult.CONTINUE;
		}

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите имя папки:");
		String dirName = scanner.nextLine();
		System.out.print("Введите минимальную длину файла:");
		int len = scanner.nextInt();
		try {
			Files.walkFileTree(Paths.get(dirName), new Finder(len)); // Текущий каталог
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
