package com.javaquasar.java.core.chapter_16_IO_Stream.example.find;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class FindWithIO {

	public static void showList(File dir, int len) throws IOException {
		for (File f : dir.listFiles()) {
			if (!f.isDirectory()) {
				if (f.length() > len)
					System.out.println(f.getCanonicalPath() + "   "
							+ f.length());
			}
		}
		for (File f : dir.listFiles()) {
			if (f.isDirectory())
				showList(f, len);
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите имя папки:");
		String dirName = scanner.next();
		File dir = new File(dirName);
		if (!dir.isDirectory()) {
			System.out.println("Неправильное имя папки!");
			return;
		}
		System.out.print("Введите минимальную длину файла:");
		int len = scanner.nextInt();
		showList(dir, len);
	}

}
