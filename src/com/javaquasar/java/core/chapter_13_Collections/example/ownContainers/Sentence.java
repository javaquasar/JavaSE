package com.javaquasar.java.core.chapter_13_Collections.example.ownContainers;

import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sentence implements Iterable<String> {
	String text;

	public Sentence(String text) {
		this.text = text;
	}

	private class WordsIterator implements Iterator<String> {
		StringTokenizer st = new StringTokenizer(text);

		@Override
		public boolean hasNext() {
			return st.hasMoreTokens();
		}

		@Override
		public String next() {
			return st.nextToken();
		}

		@Override
		public void remove() {
			throw new RuntimeException("Not implemented!");
		}

	}

	public Iterator<String> iterator() {
		return new WordsIterator();
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String text = new Scanner(System.in).nextLine();
		Sentence sentence = new Sentence(text);
		for (String word : sentence)
			System.out.println(word);
	}

}
