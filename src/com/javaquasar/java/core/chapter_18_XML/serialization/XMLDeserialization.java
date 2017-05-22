package com.javaquasar.java.core.chapter_18_XML.serialization;

import java.beans.XMLDecoder;
import java.io.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class XMLDeserialization {

	public static void main(String[] args) {
		try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream("./file/18/XML_serialization.xml"))) {
			Line line = (Line) xmlDecoder.readObject();
			System.out.println(line.getFirst().getX()
					+ " "
					+ line.getFirst().getY()
					+ " "
					+ line.getSecond().getX()
					+ " "
					+ line.getSecond().getY());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}