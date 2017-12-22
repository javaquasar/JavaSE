package com.javaquasar.java.core.chapter_16_IO_Stream.practice.task_5_01;

import java.io.File;
import java.io.FilenameFilter;

public class CopyOfListFile {

	public static void main(String[] args) {
		File folder = new File("src");

		final String[] mask = { ".java", ".sys" };
		String[] files = folder.list(new FilenameFilter() {

			@Override
			public boolean accept(File folder, String name) {
				for (String s : mask)
					if (name.toLowerCase().endsWith(s)) {
						return true;
					}
				return false;
			}

		});

		for (String fileName : files) {
			System.out.println("File: " + fileName);
		}

	}

}
