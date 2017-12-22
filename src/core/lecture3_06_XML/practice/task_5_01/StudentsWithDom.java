package core.lecture3_06_XML.practice.task_5_01;

import java.io.*;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class StudentsWithDom {
	
	public static void main(String[] args) {
		try{
			Document doc;
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = db.parse(new File("./file/lecture_3_06_task_5_01_students.xml"));
			Node rootNode = doc.getDocumentElement();
		mainLoop:
			for(int i = 0; i< rootNode.getChildNodes().getLength();i++){
				Node studentsNode = rootNode.getChildNodes().item(i);
				if(studentsNode.getNodeName().equals("StudentsData")){
					for(int j=0;j<studentsNode.getChildNodes().getLength();j++){
						Node studentNode = studentsNode.getChildNodes().item(j);
						if(studentNode.getNodeName().equals("StudentData")){
							//finding attributes
							if(studentNode.getAttributes().getNamedItem("Name").getNodeValue().equals("Даниель")){
								for(int k=0;k<studentNode.getChildNodes().getLength();k++){
									Node regNode=studentNode.getChildNodes().item(k);
									if(regNode.getNodeName().equals("RegistrationCityData")){
										regNode.getAttributes().getNamedItem("Name").setNodeValue("п.Комсомольское");
										break mainLoop;
									}
								}
							}
						}
					}
				}
			}
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(new DOMSource(doc),new StreamResult(new FileOutputStream(new File("./file/lecture_3_06_task_5_01_students_corrected_DOM.xml"))));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
