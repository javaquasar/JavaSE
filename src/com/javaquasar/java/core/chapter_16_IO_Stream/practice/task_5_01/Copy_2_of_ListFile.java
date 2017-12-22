package com.javaquasar.java.core.chapter_16_IO_Stream.practice.task_5_01;

import java.io.File;
import java.io.IOException;

public class Copy_2_of_ListFile {

	public static void main(String[] args) {
		if (args.length == 0) {
			args = new String[] { ".." };
		}
		try {
			File pathName = new File(args[0]);
			String[] fileNames = pathName.list();

			for (int i = 0; i < fileNames.length; i++) {
				File f = new File(pathName.getPath(), fileNames[i]);
				if (f.isDirectory()) {
					System.out.println(f.getCanonicalPath());
					main(new String[] { f.getPath() });
				} else {
					System.out.println(f.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
