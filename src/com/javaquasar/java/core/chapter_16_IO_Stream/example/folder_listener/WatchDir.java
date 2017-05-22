package com.javaquasar.java.core.chapter_16_IO_Stream.example.folder_listener;

import java.nio.file.*;
import java.util.Scanner;
import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class WatchDir {

	@SuppressWarnings({ "resource", "unchecked" })
	public static void main(String[] args) throws Exception {
		System.out.println("Введите имя каталога:");
		Path dir = Paths.get(new Scanner(System.in).nextLine());
		// Создаем объект WatchService
		WatchService watcher = FileSystems.getDefault().newWatchService();
		// Регистрируем отслеживаемые события:
		WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
		while (true) { // бесконечный цикл
			key = watcher.take(); // ожидаем следующий набор событий
			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent<Path> ev = (WatchEvent<Path>) event;
				System.out.printf("%s: %s\n", ev.kind().name(),
						dir.resolve(ev.context()));
			}
			key.reset(); // сбрасываем состояние набора событий
		}
	}

}
