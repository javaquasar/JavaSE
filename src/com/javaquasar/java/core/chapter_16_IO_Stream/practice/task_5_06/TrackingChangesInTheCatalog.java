package com.javaquasar.java.core.chapter_16_IO_Stream.practice.task_5_06;

import java.io.IOException;
import java.nio.file.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrackingChangesInTheCatalog {

	public static final Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я0-9.,_ ]*.txt");//(b|a).*.(txt|doc|rtf) ("[A-Za-zА-Яа-я0-9_ ]+\\.txt")
	private static Matcher matcher;

	public static void main(String[] args) {
		Path path = Paths.get("./change/");
		WatchService watchService = null;
		try {
			watchService = path.getFileSystem().newWatchService();
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// Бесконечный цикл
		for (;;) {
			WatchKey key = null;
			try {
				key = watchService.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Итерации для каждого события
			for (WatchEvent event : key.pollEvents()) {
				matcher = pattern.matcher(event.context().toString());
				if (matcher.matches()) {
					switch (event.kind().name()) {
					case "OVERFLOW":
						System.out.println("We lost some events");
						break;
					case "ENTRY_CREATE":
						System.out.println("File " + event.context() + " is created!");
						break;
					case "ENTRY_MODIFY":
						System.out.println("File " + event.context() + " is modified!");
						break;
					case "ENTRY_DELETE":
						System.out.println("File " + event.context() + " is deleted!");
						break;
					}
					System.out.println("TXT");
				} else {
					System.out.println("не TXT");
				}

			}
			// Сброс ключа важен для получения последующих уведомлений
			key.reset();
		}

	}
}
