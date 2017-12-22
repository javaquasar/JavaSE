package core.lecture3_06_XML.example.continent_DOM_vs_JAXB;

import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class ContinentWithDOM {

	public static void main(String[] args) {
		try {
			Document doc;
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = db.parse(new File("./file/lecture_3_06_example_continent.xml"));
			Node rootNode = doc.getDocumentElement();
			mainLoop: for (int i = 0; i < rootNode.getChildNodes().getLength(); i++) {
				Node countriesNode = rootNode.getChildNodes().item(i);
				if (countriesNode.getNodeName().equals("CountriesData")) {
					for (int j = 0; j < countriesNode.getChildNodes().getLength(); j++) {
						Node countryNode = countriesNode.getChildNodes().item(j);
						if (countryNode.getNodeName().equals("CountryData")) {
							// Находим атрибут по имени:
							if (countryNode.getAttributes().getNamedItem("Name").getNodeValue().equals("Франция")) {
								for (int k = 0; k < countryNode.getChildNodes().getLength(); k++) {
									Node capitalNode = countryNode.getChildNodes().item(k);
									if (capitalNode.getNodeName().equals("CapitalData")) {
										capitalNode.getAttributes().getNamedItem("Name").setNodeValue("Париж");
										break mainLoop;
									}
								}
							}
						}
					}
				}
			}
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(new File("./file/lecture_3_06_example_continent_corrected_DOM.xml"))));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
