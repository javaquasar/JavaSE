package com.javaquasar.java.core.chapter_21_Network.example.url;

import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://ru.wikipedia.org/wiki/HTTP");
            URLConnection con = url.openConnection(); // создаем соединение
            try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()))) {      // открыли поток для чтения
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    System.out.println(inputLine); // выводим строку на консоль
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
