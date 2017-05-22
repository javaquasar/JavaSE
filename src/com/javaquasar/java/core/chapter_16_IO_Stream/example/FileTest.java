package com.javaquasar.java.core.chapter_16_IO_Stream.example;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class FileTest {

	void readWrite() {
		try {
			FileReader fr = new FileReader("data.txt");
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
			int x;
			double y;
			try {
				StringTokenizer st = new StringTokenizer(s);
				x = Integer.parseInt(st.nextToken());
				y = Double.parseDouble(st.nextToken());
			} finally {
				br.close();
			}
			double z = x + y;
			FileWriter fw = new FileWriter("results.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.println(z);
			pw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileTest().readWrite();
	}

}
