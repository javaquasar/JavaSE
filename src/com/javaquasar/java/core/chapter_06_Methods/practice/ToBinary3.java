package com.javaquasar.java.core.chapter_06_Methods.practice;

import java.util.Scanner;

@SuppressWarnings("resource")
public class ToBinary3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    byte b = scanner.nextByte();
    
    
	byte byteShift = 0;
	byte tempBaseNumber = b;
	while (tempBaseNumber != 0) {
		tempBaseNumber /= 2;
		byteShift++;
	}
	
	System.out.println("byteShift = " + byteShift);
    
    for (int i = byteShift-1; i >= 0; i--) {
      System.out.print((byte)(1 & (b >> i)));
    }
  }

}
