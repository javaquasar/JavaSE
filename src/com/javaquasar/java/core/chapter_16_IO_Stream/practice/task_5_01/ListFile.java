package com.javaquasar.java.core.chapter_16_IO_Stream.practice.task_5_01;

import java.io.File;

public class ListFile {

	public static void main(String[] args) {
		File []fList;        
		File F = new File("src");
		        
		fList = F.listFiles();
		                
		for(int i=0; i<fList.length; i++)           
		{
		     //Нужны только папки в место isFile() пишим isDirectory()
		     //if(fList[i].isFile()) {
				System.out.println(String.valueOf(i) + " - " + fList[i].getName());
			//}
		}

	}

}
