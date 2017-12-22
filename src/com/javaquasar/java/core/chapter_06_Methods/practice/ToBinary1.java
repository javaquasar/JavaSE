package com.javaquasar.java.core.chapter_06_Methods.practice;

import java.util.Scanner;

@SuppressWarnings("resource")
public class ToBinary1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		byte b = scanner.nextByte();
		int printByte = 0;
		for (int i = 7; i >= 0; i--) {
			if ((printByte == 0) && ((byte) 1 & (b >> i)) != 0) {
				printByte++;
			}
			if (printByte > 0) {
				System.out.print((byte) (1 & (b >> i)));
			}
		}
	}
}
