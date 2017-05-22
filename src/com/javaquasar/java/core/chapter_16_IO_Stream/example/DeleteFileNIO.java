package com.javaquasar.java.core.chapter_16_IO_Stream.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class DeleteFileNIO {
	  public static void main(String[] args) { 
	        Path pathSource = Paths.get("Вставьте сюда путь к файлу/директории для удаления"); 
	        try { 
	            Files.delete(pathSource); 
	            System.out.println("File deleted successfully"); 
		} catch (IOException e) { 
	            e.printStackTrace(); 
	        } 
	    } 
}
