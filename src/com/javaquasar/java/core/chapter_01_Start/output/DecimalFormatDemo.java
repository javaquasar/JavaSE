package com.javaquasar.java.core.chapter_01_Start.output;

import java.text.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class DecimalFormatDemo {
	 
	   static public void customFormat(String pattern, double value ) {
	      DecimalFormat myFormatter = new DecimalFormat(pattern);
	      String output = myFormatter.format(value);
	      System.out.println(value + "  " + pattern + "  " + output);
	   }
	 
	   static public void main(String[] args) {
	 
	      customFormat("###,###.###", 123456.789);
	      customFormat("###.##", 123456.789);
	      customFormat("000000.000", 123.78);
	      customFormat("$###,###.###", 12345.67);
	   }
	}
