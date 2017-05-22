package com.javaquasar.java.core.chapter_16_IO_Stream.example;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Attributes {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		System.out.println("Введите имя файла или каталога:");
		Path path = Paths.get(new Scanner(System.in).nextLine());
		BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
		System.out.println("Время создания: " + attr.creationTime());
		System.out .println("Время последнего доступа: " + attr.lastAccessTime());
		System.out.println("Время последнего изменения: " + attr.lastModifiedTime());
		System.out.println("Каталог: " + attr.isDirectory());
		System.out.println("Обычный файл: " + attr.isRegularFile());
		System.out.println("Размер: " + attr.size());
	}

}