package com.javaquasar.java.core.chapter_18_XML.practice.task_5_04;

import java.beans.XMLEncoder;
import java.io.*;

public class XMLSerialization {

	public static void main(String[] args) {
		Group group = new Group("АТР", new Student("Аурур", "Бузов", "АТР", "5"), new Student("Иван", "Бойко", "АТР", "4"), new Student("Кирил", "Фейман", "АТР", "3"));
		
		try (XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(
				"./file/lecture_3_06_task_5_04_XML_serialization.xml"))) {
			xmlEncoder.writeObject(group);
			xmlEncoder.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

