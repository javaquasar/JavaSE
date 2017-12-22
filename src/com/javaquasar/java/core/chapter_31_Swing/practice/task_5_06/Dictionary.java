package com.javaquasar.java.core.chapter_31_Swing.practice.task_5_06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dictionary {
    private int progress = 100;
	private Map<String, String> dictionary = new TreeMap<>();
	private Map<Integer, String> key = new TreeMap<>();
	private String pathToFile = null;
	private static Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я0-9_ +]+[|]{1}[A-Za-zА-Яа-я0-9_, +]+");

	public static void main(String[] args) throws IOException {
		String fileDictionary = "./file/lecture_3_09_task_5_05_dictionary3.txt";
		Dictionary dictionary = getInstance(fileDictionary, 100);
		dictionary.readFromFile();
		dictionary.add(" Horse ", " КонЬ ");
		dictionary.writeToFile();

	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	private Dictionary(String pathToFile, int progress) {
		this.pathToFile = pathToFile;
		this.progress = progress;
	}

	public static Dictionary getInstance(String s, int progress) {
		Dictionary dictionary = null;
		Path file = Paths.get(s);

		//boolean isRegularExecutableFile = Files.isRegularFile(file) & Files.isReadable(file) & Files.isExecutable(file);
		boolean isRegularExecutableFile = Files.isRegularFile(file) && Files.isReadable(file) && Files.isWritable(file);

		if (isRegularExecutableFile) {
			dictionary = new Dictionary(s, progress);
		}
		return dictionary;
	}

	public void add(String key, String value) {
		dictionary.put(prepare(key), prepare(value));
	}

	public boolean containsKey(String key) {
		return dictionary.containsKey(key);
	}

	public void delete(String key) {
		dictionary.remove(key);
	}
	
	public String getValue(String key) {
		return dictionary.get(key);
	}

	/*public void readFromFile() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(pathToFile));
		try {
			String s = null;
			StringTokenizer st = null;
			Matcher matcher;
			String s1 = null;
			String s2 = null;
			while ((s = in.readLine()) != null) {
				matcher = pattern.matcher(s);
				if (matcher.matches()) {
					st = new StringTokenizer(s, "|");
					s1 = prepare(st.nextToken());
					s2 = prepare(st.nextToken());
					dictionary.put(s1, s2);
					key.put(dictionary.size()-1, s1);
				}
			}
			System.out.println(dictionary);
			System.out.println(key);
		} finally {
			in.close();
		}
	}*/
	
	public void readFromFile() throws IOException {
		Scanner in = new Scanner(new FileReader(pathToFile));
		try {
			if(in.hasNextInt()) {
				progress = in.nextInt(); 
		    }
			String s = null;
			StringTokenizer st = null;
			Matcher matcher;
			String s1 = null;
			String s2 = null;
			while (in.hasNext()) {
				s = in.nextLine();
				matcher = pattern.matcher(s);
				if (matcher.matches()) {
					st = new StringTokenizer(s, "|");
					s1 = prepare(st.nextToken());
					s2 = prepare(st.nextToken());
					dictionary.put(s1, s2);
					key.put(dictionary.size()-1, s1);
				}
			}
			//System.out.println(dictionary);
			//System.out.println(key);
		} finally {
			in.close();
		}
	}
	
	

	public void writeToFile() throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(pathToFile));
		out.println(progress);
		for (Map.Entry<String, String> entry : dictionary.entrySet()) {
			out.println(entry.getKey() + " | " + entry.getValue());
		}
		out.flush();
		out.close();
	}
	
	public static String prepareWord(String s) {
		return s.toLowerCase().replaceAll(" ", "");
	}

	public static String prepare(String s) {
		return s.toLowerCase().trim();
	}
	
	public int getSize() {
		return dictionary.size();
	}
	
	public String getRandomKey() {
		return key.get((int) (Math.random() * (getSize()-1)));
	}
	
	public String getRandomValue(){
		return dictionary.get(getRandomKey());
	}

}
