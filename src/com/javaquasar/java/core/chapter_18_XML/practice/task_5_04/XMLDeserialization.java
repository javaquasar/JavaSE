package com.javaquasar.java.core.chapter_18_XML.practice.task_5_04;

import java.beans.XMLDecoder;
import java.io.*;

public class XMLDeserialization {

	public static void main(String[] args) {
		try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(
				"./file/lecture_3_06_task_5_04_XML_serialization.xml"))) {
			Group group = (Group)  xmlDecoder.readObject();
			for (Student student : group.getStudents()) {
				System.out.println(student.getName() + " " + student.getLastname() + " " + student.getCours());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}