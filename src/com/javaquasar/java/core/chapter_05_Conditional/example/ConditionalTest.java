package com.javaquasar.java.core.chapter_05_Conditional.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ConditionalTest {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double x = scanner.nextDouble();
    double y = x < -8 ? 100 : (x <= 1 ? 200 : 300);
    System.out.println(y);
  }

}
