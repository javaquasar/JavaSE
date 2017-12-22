package core.lecture3_02_Collections.example;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Countries {

	public static void main(String[] args) {
		SortedMap<String, Double> countries = new TreeMap<>();
		countries.put("Украина", 603700.0);
		countries.put("Германия", 357021.0);
		countries.put("Франция", 547030.0);
		for (Map.Entry<?, ?> entry : countries.entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue());
	}

}
