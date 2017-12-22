package com.javaquasar.java.core.chapter_18_XML.example.hello_SAX;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HelloSAX extends DefaultHandler {

	@Override
	public void startDocument() {
		System.out.println("Opening document");
	}

	@Override
	public void endDocument() {
		System.out.println("Done");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("Opening tag: " + qName);
		if (attributes.getLength() > 0) {
			System.out.println("Атрибуты: ");
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.println("  " + attributes.getQName(i) + ": " + attributes.getValue(i));
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("Closin tag: " + qName);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s = new String(ch).substring(start, start + length).trim();
		if (s.length() > 0) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		SAXParser parser = null;
		try {
			parser = SAXParserFactory.newInstance().newSAXParser();
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
		if (parser != null) {
			InputSource input = new InputSource("./file/lecture_3_06_example_hello_SAX.xml");
			try {
				parser.parse(input, new HelloSAX());
			} catch (SAXException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
