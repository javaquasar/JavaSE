package com.javaquasar.java.core.chapter_16_IO_Stream.example.find;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class FindMatched {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String dirName = scanner.nextLine();
		String pattern = scanner.nextLine();
		Path dir = Paths.get(dirName);
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher(
				"glob:" + pattern);
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir)) {
			for (Path file : ds) {
				if (matcher.matches(file.getFileName()))
					System.out.println(file.getFileName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
