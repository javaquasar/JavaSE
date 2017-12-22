package com.javaquasar.java.core.chapter_16_IO_Stream.practice.task_5_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListFileWithDelete {

	// private static StringBuilder stringBuilder = new StringBuilder();
	private static List<String> list = new LinkedList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		search(args);
		String fileResultPath = "./file/lecture_3_07_task_5_01_result.txt";
		try (PrintWriter applicantsWriter = new PrintWriter(fileResultPath)) {
			for (String s : list) {
				applicantsWriter.println(s);
				applicantsWriter.println("\r\n");
			}
		} catch (FileNotFoundException e) {

		}

		System.out.println("Чтобы удалить файл введите 1");
        int i = scanner.nextInt();
		if (i == 1) {
			File file = new File(fileResultPath);
			if (!file.delete()) {
				System.out.println("The file is not deleted!");
			} else {
				System.out.println("File deleted successfully!");
			}
		}

	}

	public static void search(String[] s) {
		if (s.length == 0) {
			s = new String[] { ".." };
		}
		try {
			File pathName = new File(s[0]);
			String[] fileNames = pathName.list();

			for (int i = 0; i < fileNames.length; i++) {
				File f = new File(pathName.getPath(), fileNames[i]);
				if (f.isDirectory()) {
					// stringBuilder.append(f.getCanonicalPath());
					list.add(f.getCanonicalPath());
					// System.out.println(f.getCanonicalPath());
					search(new String[] { f.getPath() });
				} else {
					// stringBuilder.append(f.getCanonicalPath());
					list.add(f.getCanonicalPath());
					// System.out.println(f.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
