package com.javaquasar.java.core.chapter_18_XML.practice.task_5_02;

import java.io.*;

import javax.xml.bind.*;

import com.javaquasar.java.core.chapter_18_XML.practice.task_5_02.group.GroupData;

public class GroupWithJAXB {

	public static void main(String[] args) {
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance("buzov.lecture3_06.practice.task_5_02.group");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			GroupData data = (GroupData)unmarshaller.unmarshal(new FileInputStream("./file/lecture_3_06_task_5_02_students.xml"));
			//
			for(GroupData.StudentsData.StudentData c: data.getStudentsData().getStudentData()){
				if(c.getName().equals("Даниель")){
					c.getRegistrationCityData().setName("п.Комсомольское");
					break;
				}
			}
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(data, new FileWriter("./file/lecture_3_06_task_5_02_group_corrected_JAXB.xml"));
		}
		catch(JAXBException|IOException e){
			e.printStackTrace();
		}
	}
	
}
