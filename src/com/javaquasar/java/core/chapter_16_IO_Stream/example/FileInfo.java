package com.javaquasar.java.core.chapter_16_IO_Stream.example;

import java.io.File;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class FileInfo {

	static void p(String s) {
		System.out.println(s);
	}

	public static void main(String args[]) {
		File fl = new File("2lecture_3_05_task_5_08.txt");
		p("Имя файла:" + fl.getName());
		p("Путь:" + fl.getPath());
		p("Полный путь:" + fl.getAbsolutePath());
		p("Родительский каталог:" + fl.getParent());
		p(fl.exists() ? "существует" : "не существует");
		p(fl.canWrite() ? "можно записывать" : "нельзя записывать");
		p(fl.canRead() ? "можно читать" : "нельзя читать");
		p("is" + "Директория? " + (fl.isDirectory() ? "да" : " нет"));
		p(fl.isFile() ? "обычный файл" : "не обычный файл");
		p("Последняя модификация файла:" + fl.lastModified());
		p("Размер файла:" + fl.length() + " Bytes");
		p("Скрытый:" + (fl.isHidden() ? "да" : " нет"));
	}
}
