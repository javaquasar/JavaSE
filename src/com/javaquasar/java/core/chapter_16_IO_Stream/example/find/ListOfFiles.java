package com.javaquasar.java.core.chapter_16_IO_Stream.example.find;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ListOfFiles {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите имя папки:");
		String dirName = scanner.next();
		File dir = new File(dirName);
		if (!dir.isDirectory()) {
			System.out.println("Неправильное имя папки!");
			return;
		}
		String[] list = dir.list();
		for (String name : list)
			System.out.println(name);
	}

}
