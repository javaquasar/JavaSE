package com.javaquasar.java.core.chapter_18_XML.serialization;

import java.beans.XMLEncoder;
import java.io.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class XMLSerialization {

	public static void main(String[] args) {
		Line line = new Line();
		line.getFirst().setX(1);
		line.getFirst().setY(2);
		line.getSecond().setX(3);
		line.getSecond().setY(4);
		try (XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(
				"./file/18/XML_serialization.xml"))) {
			xmlEncoder.writeObject(line);
			xmlEncoder.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

/*<?xml version="1.0" encoding="UTF-8"?>
<java version="1.8.0_25" class="java.beans.XMLDecoder">
 <object class="com.javaquasar.java.core.chapter_18_XML.serialization" id="Line0">
  <void property="first">
   <void property="x">
    <double>1.0</double>
   </void>
   <void property="y">
    <double>2.0</double>
   </void>
  </void>
  <void property="second">
   <void property="x">
    <double>3.0</double>
   </void>
   <void property="y">
    <double>4.0</double>
   </void>
  </void>
 </object>
</java>*/
