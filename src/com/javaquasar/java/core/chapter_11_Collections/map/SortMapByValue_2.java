package com.javaquasar.java.core.chapter_11_Collections.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SortMapByValue_2 {
	public static void main(String[] args){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 10);
		map.put("b", 30);
		map.put("c", 50);
		map.put("d", 40);
		map.put("e", 20);
		System.out.println(map);
 
		TreeMap<String, Integer> sortedMap = sortByValue(map);  
		System.out.println(sortedMap);
	}
 
	public static TreeMap<String, Integer> sortByValue (HashMap<String, Integer> map) {
		ValueComparator_2 vc =  new ValueComparator_2(map);
		TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(vc);
		sortedMap.putAll(map);
		return sortedMap;
	}
}
 
class ValueComparator_2 implements Comparator<String> {
 
    Map<String, Integer> map;
 
    public ValueComparator_2(Map<String, Integer> base) {
        this.map = base;
    }
 
    public int compare(String a, String b) {
        if (map.get(a) >= map.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys 
    }
}