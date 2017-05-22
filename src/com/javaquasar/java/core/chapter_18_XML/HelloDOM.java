package com.javaquasar.java.core.chapter_18_XML;

import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class HelloDOM {

	public static void main(String[] args) throws Exception {
		Document doc; // ссылка на объект "документ"
		// Создаем "построитель документов" с помощью "фабричного метода":
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		doc = db.parse(new File("./file/18/hello_DOM.xml"));
		// Находим корневой тег:
		Node rootNode = doc.getDocumentElement();
		// Просматриваем все "дочерние" теги:
		for (int i = 0; i < rootNode.getChildNodes().getLength(); i++) {
			Node currentNode = rootNode.getChildNodes().item(i);
			if (currentNode.getNodeName().equals("Hello")) {
				// Просматриваем все атрибуты:
				for (int j = 0; j < currentNode.getAttributes().getLength(); j++) {
					if (currentNode.getAttributes().item(j).getNodeName().equals("Text")) {
						// Нашли нужный атрибут. Выводим текст атрибута -
						// приветствие:
						System.out.println(currentNode.getAttributes().item(j).getNodeValue());
						// Изменяем содержимое атрибута:
						currentNode.getAttributes().item(j).setNodeValue("Привет, здесь был DOM!");
						// Дальнейший поиск нецелесообразен:
						break;
					}
				}
				// Изменяем текст:
				System.out.println(currentNode.getTextContent());
				currentNode.setTextContent("\n    Привет, здесь тоже был DOM!\n");
				break;
			}
		}
		// Создание объекта-преобразователя (в данном случае - для записи в
		// файл).
		// Используем фабричный метод:
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		// Запись в файл:
		transformer.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(new File("./file/18/hello_DOM_result.xml"))));
	}

}
