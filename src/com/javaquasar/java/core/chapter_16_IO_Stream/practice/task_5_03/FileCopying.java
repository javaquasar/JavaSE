package com.javaquasar.java.core.chapter_16_IO_Stream.practice.task_5_03;

import java.io.*;
import java.util.*;

public class FileCopying {

	public static void main(String[] args) throws IOException {
		File dir = new File("newFolder");
		if (!dir.mkdir()) {
			//System.out.println("!");
			//return;
		}
		
		File startDir = new File("."+"\\test");
		String[] list = startDir.list();
		System.out.println(Arrays.toString(list));
		for(int i = 0; i<list.length;i++){
			copyFile(new File(startDir+"\\"+list[i]),new File(dir+"\\"+list[i]));
		}
		//startDir.delete();
		

	}
	private static void copyFile(File source,File dest) throws IOException{
		try(DataInputStream in = new DataInputStream(new FileInputStream(source));
			DataOutputStream out = new DataOutputStream(new FileOutputStream(dest))){
			byte[] buffer = new byte[1024];
			int length;
			while((length = in.read(buffer))>0){
				out.write(buffer, 0 ,length);
			}
		}
	} 

}
