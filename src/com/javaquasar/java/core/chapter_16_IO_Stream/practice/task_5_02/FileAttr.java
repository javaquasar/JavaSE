package com.javaquasar.java.core.chapter_16_IO_Stream.practice.task_5_02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.util.jar.Attributes;

/*5.8 Получение информации об атрибутах файлов*

Разработать программу, которая для заданного файла (каталога) 
выдает информацию об его атрибутах. Использовать класс DosFileAttributes.*/

public class FileAttr {
	public static void main(String[] args) {
		try {

			String path = "./file/lecture_3_07_task_5_02_read.txt";
			String path2 = "lecture_3_08_task_5_02_2.txt";
			File f = new File(path);
			File f2 = new File(path2);
			FileWriter fw = new FileWriter(f);
			fw.write("testвапапвапвапвапвапвпв");
			fw.close();

			Path p = f.toPath();
			Path p2 = f2.toPath();
			System.out.println(p);

			String probeContentType = Files.probeContentType(p);
			System.out.println("type " + probeContentType);

			BasicFileAttributes attr = Files.readAttributes(p, BasicFileAttributes.class);

			System.out.println("creationTime: " + attr.creationTime());
			System.out.println("lastAccessTime: " + attr.lastAccessTime());
			System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

			System.out.println("isDirectory: " + attr.isDirectory());
			System.out.println("isOther: " + attr.isOther());
			System.out.println("isRegularFile: " + attr.isRegularFile());
			System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
			System.out.println("size: " + attr.size());

			/*DosFileAttributes attr2 = Files.readAttributes(p2, DosFileAttributes.class);
			System.out.println("isReadOnly is " + attr2.isReadOnly());
			System.out.println("isHidden is " + attr2.isHidden());
			System.out.println("isArchive is " + attr2.isArchive());
			System.out.println("isSystem is " + attr2.isSystem());*/
		} catch (IOException x) {
			System.err.println("DOS file attributes not supported:" + x);
		}
	}
}
