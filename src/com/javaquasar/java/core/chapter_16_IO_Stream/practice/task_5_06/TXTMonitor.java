package com.javaquasar.java.core.chapter_16_IO_Stream.practice.task_5_06;

import java.nio.file.*;
import java.util.Scanner;

import static java.nio.file.StandardWatchEventKinds.*;

public class TXTMonitor {

	public static void main(String[] args) throws Exception {
		System.out.println("");
		Path dir = Paths.get(new Scanner(System.in).nextLine());
		//Path dir = Paths.get("c:/test");
		WatchService watcher = FileSystems.getDefault().newWatchService();
		WatchKey key = dir.register(watcher,ENTRY_CREATE, ENTRY_DELETE,ENTRY_MODIFY);
		while(true){
			key = watcher.take();
			for (WatchEvent<?> event: key.pollEvents()){
				WatchEvent<Path> ev = (WatchEvent<Path>) event;
				if(ev.context().toString().endsWith(".txt")){
				System.out.printf("%s: %s\n",ev.kind().name(),dir.resolve(ev.context()));
				}
			}
			key.reset();
		}
	}
	
}
