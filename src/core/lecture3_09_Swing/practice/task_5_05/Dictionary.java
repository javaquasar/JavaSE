package core.lecture3_09_Swing.practice.task_5_05;

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

	private Map<String, String> dictionary = new TreeMap<>();
	private String pathToFile = null;
	private static Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я0-9_ +]+[|]{1}[A-Za-zА-Яа-я0-9_, +]+");

	public static void main(String[] args) throws IOException {
		String fileDictionary = "./file/lecture_3_09_task_5_05_dictionary.txt";
		// new Dictionary(fileDictionary).readFromFile(fileDictionary);
		Dictionary dictionary = getInstance(fileDictionary);
		dictionary.readFromFile();
		dictionary.add(" Horse ", " КонЬ ");
		dictionary.writeToFile();

	}

	private Dictionary(String pathToFile) {
		this.pathToFile = pathToFile;
	}

	public static Dictionary getInstance(String s) {
		Dictionary dictionary = null;
		Path file = Paths.get(s);
		
		//System.out.println(Files.isRegularFile(file));
		//System.out.println(Files.isReadable(file));
		//System.out.println(Files.isWritable(file));
		//System.out.println(Files.isExecutable(file));

		//boolean isRegularExecutableFile = Files.isRegularFile(file) & Files.isReadable(file) & Files.isExecutable(file);
		boolean isRegularExecutableFile = Files.isRegularFile(file) && Files.isReadable(file) && Files.isWritable(file);

		if (isRegularExecutableFile) {
			dictionary = new Dictionary(s);
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

	/*
	 * public void readWrite() { PriorityQueue<String> priorityQueue = new
	 * PriorityQueue<>(); try (Scanner scanner = new Scanner(new
	 * FileReader("./file/lecture_3_09_task_5_05_dictionary.txt"))) { while
	 * (scanner.hasNext()) { priorityQueue.add(scanner.nextLine()); } try
	 * (PrintWriter pw = new
	 * PrintWriter("./file/lecture_3_09_task_5_05_dictionary.txt")) { for
	 * (String s : priorityQueue) { pw.println(s); } } } catch (IOException ex)
	 * { ex.printStackTrace(); } }
	 */

	public void readFromFile() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(pathToFile));
		try {
			String s = null;
			// String[] words = null;
			StringTokenizer st = null;
			Matcher matcher;
			while ((s = in.readLine()) != null) {
				matcher = pattern.matcher(s);
				if (matcher.matches()) {
					st = new StringTokenizer(s, "|");
					// words = s.split("\\s+");

					// System.out.println(words[0]);
					// System.out.println(words[1]);
					// dictionary.put(prepare(words[0]), prepare(words[1]));
					// System.out.println(prepare(st.nextToken()));
					// System.out.println(prepare(st.nextToken()));
					dictionary.put(prepare(st.nextToken()), prepare(st.nextToken()));
				}
			}
		} finally {
			in.close();
		}
		//System.out.println(dictionary);
	}

	public void writeToFile() throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(pathToFile));
		for (Map.Entry<String, String> entry : dictionary.entrySet()) {
			out.println(entry.getKey() + " | " + entry.getValue());
		}
		out.close();
	}
	
	public static String prepareWord(String s) {
		return s.toLowerCase().replaceAll(" ", "");
	}

	public static String prepare(String s) {
		return s.toLowerCase().trim();
	}

}
