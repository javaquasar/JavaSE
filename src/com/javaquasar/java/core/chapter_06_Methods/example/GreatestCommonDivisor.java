package com.javaquasar.java.core.chapter_06_Methods.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class GreatestCommonDivisor {

  static int gcd(int m, int n) {
    while (m != n) {
      if (m > n)
        m -= n;
      else
        n -= m;
    }
    return m;
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int m = s.nextInt();
    int n = s.nextInt();
    System.out.println(gcd(m, n));
  }

}