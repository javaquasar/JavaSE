package com.javaquasar.java.core.chapter_16_IO_Stream.practice.task_5_02;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.DosFileAttributes;
import java.util.Scanner;

public class Attributes {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Укажите путь к файлу");
		Path path = Paths.get(new Scanner(System.in).nextLine());
		DosFileAttributes attr = Files.readAttributes(path, DosFileAttributes.class);
		System.out.println(attr.isReadOnly());
		System.out.println(attr.isArchive());
		System.out.println(attr.isHidden());
		System.out.println(attr.isSystem());
	}
 
}

