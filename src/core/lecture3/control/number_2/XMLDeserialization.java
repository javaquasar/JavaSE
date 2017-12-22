package core.lecture3.control.number_2;

import java.beans.XMLDecoder;
import java.io.*;

public class XMLDeserialization {

	public static void main(String[] args) {
		try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(
				"InformationAboutApplicants.xml"))) {
			InformationAboutApplicants iaa = (InformationAboutApplicants) xmlDecoder.readObject();
			try (PrintWriter applicantsWriter = new PrintWriter("lecture_3_control_18_01_2015.txt")) {
				applicantsWriter.println(iaa.toString());
			} 
			System.out.println(iaa);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}