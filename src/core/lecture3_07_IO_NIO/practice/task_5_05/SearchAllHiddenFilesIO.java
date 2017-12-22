package core.lecture3_07_IO_NIO.practice.task_5_05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SearchAllHiddenFilesIO {

	private static List<String> list = new LinkedList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		search(args);
		String fileResultPath = "./file/lecture_3_07_task_5_05_result_hidden_files.txt";
		try (PrintWriter applicantsWriter = new PrintWriter(fileResultPath)) {
			for (String s : list) {
				applicantsWriter.println(s);
				applicantsWriter.println("\r\n");
			}
		} catch (FileNotFoundException e) {

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
					if (f.isHidden()) {
						// stringBuilder.append(f.getCanonicalPath());
						list.add(f.getCanonicalPath());
						// System.out.println(f.getCanonicalPath());
					}
				} else {
					if (f.isHidden()) {
						// stringBuilder.append(f.getCanonicalPath());
						list.add(f.getCanonicalPath());
						// System.out.println(f.getCanonicalPath());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
