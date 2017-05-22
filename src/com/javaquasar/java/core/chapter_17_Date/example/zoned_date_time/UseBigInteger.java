package com.javaquasar.java.core.chapter_17_Date.example.zoned_date_time;

import java.math.BigInteger;
import java.util.Random;

public class UseBigInteger {

	public static void main(String[] args) {
		BigInteger number;
		for (int i = 1; i < 11; i++) {
			number = getRandomBigInteger();
			System.out.println(i + " -> " + number);
		}
	}

	public static BigInteger getRandomBigInteger() {
		return new BigInteger(10, new Random());
	}

}
