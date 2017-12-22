package com.javaquasar.java.core.chapter_08_Look_at_Classes_and_Objects.example;

import java.util.StringTokenizer;

public class Census {
	private int year;
	private int population;
	private String comments;

	public Census(int year, int population, String comments) {
		this.year = year;
		this.population = population;
		this.comments = comments;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean containsWord(String word) {
		StringTokenizer st = new StringTokenizer(comments);
		String s;
		while (st.hasMoreTokens()) {
			s = st.nextToken();
			if (s.toUpperCase().equals(word.toUpperCase()))
				return true;
		}
		return false;
	}

	public boolean containsSubstring(String substring) {
		return comments.toUpperCase().indexOf(substring.toUpperCase()) >= 0;
	}

	private void testWord(String word) {
		if (containsWord(word))
			System.out.println("Слово " + word + " содержится в комментарии");
		else
			System.out
					.println("Слово " + word + " не содержится в комментарии");
		if (containsSubstring(word))
			System.out.println("Текст " + word + " содержится в комментарии");
		else
			System.out
					.println("Текст " + word + " не содержится в комментарии");
	}

	public static void main(String[] args) {
		Census census = new Census(2001, 48475100,
				"Первая перепись в независимой Украине");
		census.testWord("Украине");
		census.testWord("не");
		census.testWord("Украина");
	}
}