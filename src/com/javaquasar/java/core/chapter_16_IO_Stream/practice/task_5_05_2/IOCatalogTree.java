package com.javaquasar.java.core.chapter_16_IO_Stream.practice.task_5_05_2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.attribute.DosFileAttributes;

public class IOCatalogTree {

	public static void showHiddenList(File dir) throws IOException {
		for (File f : dir.listFiles()) {
			if (!f.isDirectory()) {
				DosFileAttributes attr = Files.readAttributes(dir.toPath(), DosFileAttributes.class);
				if (attr.isHidden())
					System.out.println(f.getCanonicalPath());
			}
		}
		for (File f : dir.listFiles()) {
			if (f.isDirectory())
				showHiddenList(f);
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print(":");
		String dirName = scanner.next();
		File dir = new File(dirName);
		if (!dir.isDirectory()) {
			System.out.println("!");
			return;
		}
		showHiddenList(dir);
	}

}
