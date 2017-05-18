package com.javaquasar.java.core.chapter_04_Arrays.multidimensional;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class AlternativeArrayDeclarationSyntax {

	public static void main(String[] args) {
		int al[] = new int[3];
		int[] a2 = new int[3];
		//The following declarations are also equivalent:
		char twod1[][] = new char[3][4];
		char[][] twod2 = new char[3][4];
		//This alternative declaration form offers convenience when 
		//declaring several arrays at the
		//same time. For example,
		int[] nums, nums2, nums3; // create three arrays
		//creates three array variables of type int. It is the same as writing
		int nums_[], nums2_[], nums3_[]; // create three arrays
	}
}
