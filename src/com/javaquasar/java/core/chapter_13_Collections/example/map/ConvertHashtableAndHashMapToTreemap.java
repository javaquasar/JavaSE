package com.javaquasar.java.core.chapter_13_Collections.example.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ConvertHashtableAndHashMapToTreemap {

	public static void main(String[] args) {
		Map<Integer, String> hashTable = new Hashtable<Integer, String>();
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		Map<Integer, String> mapHashtable = new TreeMap<Integer, String>(hashTable);
		Map<Integer, String> mapHashMap = new TreeMap<Integer, String>(hashMap);
	}

}
