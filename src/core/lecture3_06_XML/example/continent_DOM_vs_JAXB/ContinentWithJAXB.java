package core.lecture3_06_XML.example.continent_DOM_vs_JAXB;

import java.io.*;
import javax.xml.bind.*;

public class ContinentWithJAXB {

	public static void main(String[] args) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("buzov.lecture3_06.example.continent_DOM_vs_JAXB");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			ContinentData data = (ContinentData) unmarshaller.unmarshal(new FileInputStream("./file/lecture_3_06_example_continent.xml"));
			// Работаем со списком элементов CountryData:
			for (ContinentData.CountriesData.CountryData c : data.getCountriesData().getCountryData()) {
				if (c.getName().equals("Франция")) {
					c.getCapitalData().setName("Париж");
					break;
				}
			}
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(data, new FileWriter("./file/lecture_3_06_example_continent_corrected_JAXB.xml"));
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}

}
