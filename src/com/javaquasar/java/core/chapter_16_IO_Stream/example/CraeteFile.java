package com.javaquasar.java.core.chapter_16_IO_Stream.example;

import java.io.File;
import java.io.IOException;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class CraeteFile {
	public static void main(String[] args) throws IOException {
		File file = new File("./file/16/new_file.txt");
		File dir = file.getParentFile();
		if (false == file.exists()) {
			dir.mkdir();
		}
		file.createNewFile();
	}
}
