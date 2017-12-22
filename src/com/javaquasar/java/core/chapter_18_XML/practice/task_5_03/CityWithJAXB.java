package com.javaquasar.java.core.chapter_18_XML.practice.task_5_03;

import java.io.*;
import javax.xml.bind.*;

public class CityWithJAXB {

	public static void main(String[] args) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("buzov.lecture3_06.practice.task_5_03");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			CountryData data = (CountryData) unmarshaller.unmarshal(new FileInputStream("./file/lecture_3_06_task_5_03_city.xml"));
			// Работаем со списком элементов CountryData:
			for (CountryData.СitiesData.CityData c : data.getСitiesData().getCityData()) {
				if (c.getName().equals("Харьков")) {
					c.getMayorData().setName("Кернес");//getCapitalData().setName("Париж");
					break;
				}
			}
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(data, new FileWriter("./file/lecture_3_06_task_5_03_city_corrected_JAXB.xml"));
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}

}
