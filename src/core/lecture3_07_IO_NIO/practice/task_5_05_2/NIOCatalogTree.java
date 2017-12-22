package core.lecture3_07_IO_NIO.practice.task_5_05_2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.DosFileAttributes;
import java.util.Scanner;

public class NIOCatalogTree {

	private static class Finder extends SimpleFileVisitor<Path> {
		DosFileAttributes attr;

		Finder(Path path) throws IOException {
			this.attr = Files.readAttributes(path, DosFileAttributes.class);
		}

		public FileVisitResult visitFile(Path file) {
			if (attr.isHidden())
				System.out.println(file);
			return FileVisitResult.CONTINUE;
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(":");
		String dirName = scanner.nextLine();

		try {
			Files.walkFileTree(Paths.get(dirName), new Finder(Paths.get(dirName))); //
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
