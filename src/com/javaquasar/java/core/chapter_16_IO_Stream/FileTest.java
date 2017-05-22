package com.javaquasar.java.core.chapter_16_IO_Stream;

import java.io.*;
import java.util.*;

public class FileTest {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите имя папки, которую вы хотите создать:");
		String dirName = scanner.next();
		File dir = new File(dirName);
		// Создаем новую папку:
		if (!dir.mkdir()) {
			System.out.println("Нельзя создать папку!");
			return;
		}
		// Создаем новый файл внутри новой папки:
		File file = new File(dir + "\\temp.txt");
		file.createNewFile();
		// Показываем список файлов папки:
		System.out.println(Arrays.asList(dir.list()));
		file.delete(); // Удаляем файл
		dir.delete(); // Удаляем папку
	}

}
