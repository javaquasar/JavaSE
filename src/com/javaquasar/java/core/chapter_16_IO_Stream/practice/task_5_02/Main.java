package com.javaquasar.java.core.chapter_16_IO_Stream.practice.task_5_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class Main {
	public static void main(String[] args) {
		DosFileAttributes attr = null;
		//Path path = Paths.get("/Users/artur/Documents/workspace_luna/Nix/lecture_3_05_task_5_08.txt");
		
		Path path = Paths.get("./file/lecture_3_07_task_5_01_result.txt");

		try {
			attr = Files.readAttributes(path, DosFileAttributes.class);
		} catch (IOException e) {
			System.err.println(e);
		}
		System.out.println("Is archive ? " + attr.isArchive());
	}
}
