package com.javaquasar.java.core.chapter_18_XML.example.hello_JAXB;

import java.io.*;
import javax.xml.bind.*;

public class HelloJAXB {

	public static void main(String[] args) {
		try {
			// Через объект класса JAXBContext обеспечивается доступ к средствам
			// JAXB API:
			// пакет с необходимыми классами
			JAXBContext jaxbContext = JAXBContext.newInstance("buzov.lecture3_06.example.hello_JAXB"); 
			// Читаем данные из файла и загружаем в объект сгенерированного
			// класса:
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Greetings greetings = (Greetings) unmarshaller.unmarshal(new FileInputStream("./file/lecture_3_06_example_hello_JAXB.xml"));
			// Выводим старое значение атрибута:
			System.out.println(greetings.getHello().getText());
			// Меняем значение атрибута:
			greetings.getHello().setText("Привет, JAXB!");
			// Создаем объект-Marshaller для вывода в файл:
			Marshaller marshaller = jaxbContext.createMarshaller();
			// "Включаем" форматирование:
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// Сохраняем объект в новом файле:
			marshaller.marshal(greetings, new FileWriter("./file/lecture_3_06_example_hello_JAXB_result.xml"));
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}

}
