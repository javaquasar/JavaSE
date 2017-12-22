package core.lecture3_02_Collections.example;

import java.util.*;

public class WordsCounter {
	public static void main(String[] args) {
		Map<String, Integer> m = new TreeMap<String, Integer>();
		String s = "the first men on the moon";
		StringTokenizer st = new StringTokenizer(s);
		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			Integer count = m.get(word);
			m.put(word, (count == null) ? 1 : count + 1);
		}
		for (String word : m.keySet())
			System.out.println(word + " " + m.get(word));
	}

}
