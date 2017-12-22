package core.lecture3.control.number_2;

import java.beans.XMLEncoder;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class XMLSerialization {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("java");
		set.add("c++");
		
		Applicant[] applicants = new Applicant[6];
		
		applicants[0] = new Applicant("Артур", "Бузов", 1990, 5, 14, "c0nst@money.simply.net", set);
		applicants[1] = new Applicant("Артур", "Бузов", 1990, 5, 14, "somebody@dev", set);
		applicants[2] = new Applicant("Павел", "Картавкин", 1990, 5, 14, "Name.Sur_name@gmail.com", set);
		applicants[3] = new Applicant("Олег", "Синяговский", 1990, 5, 14, "buzov.artur@gmail.com", set);
		applicants[4] = new Applicant("Кирил", "Подкуйко", 1990, 5, 14, "buzov.artur@yandex.ru", set);
		applicants[5] = new Applicant("Светлана", "Крыжний", 1990, 5, 14, "12b3R33$somewhere.in.the.net", set);
		
		InformationAboutApplicants iaa = new InformationAboutApplicants();
		
		for(Applicant a : applicants) {
			iaa.add(a);
		}
		iaa.add(new Applicant("Артур", "Їузов", 1990, 5, 14, "c0nst@money.simply.net", set));
		try (XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(
				"InformationAboutApplicants.xml"))) {
			xmlEncoder.writeObject(iaa);
			xmlEncoder.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

/*<?xml version="1.0" encoding="UTF-8"?>
<java version="1.8.0_25" class="java.beans.XMLDecoder">
 <object class="buzov.lecture3_06.Line" id="Line0">
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



