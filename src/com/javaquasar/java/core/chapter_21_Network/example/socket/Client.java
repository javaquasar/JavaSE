package com.javaquasar.java.core.chapter_21_Network.example.socket;

import java.net.*;
import java.util.*;
import java.io.*;

public class Client {

	public static void main(String[] args) {
		// Указываем порт, к которому привязывается сервер
		int serverPort = 7777;
		// IP-адрес компьютера, где исполняется наша серверная программа
		String address = "127.0.0.1"; // адрес данного компьютера
		try {
			// Создаем объект который отображает указанный IP-адрес.
			InetAddress ipAddress = InetAddress.getByName(address);
			// Создаем сокет, используя IP-адрес и порт сервера.
			try (Socket socket = new Socket(ipAddress, serverPort)) {
				System.out.println("Сервер найден!");

				// Получаем входной и выходной потоки сокета
				// Теперь можем получать и отсылать данные клиенту:
				DataInputStream in = new DataInputStream(
						socket.getInputStream());
				DataOutputStream out = new DataOutputStream(
						socket.getOutputStream());

				// Создаем сканнер:
				@SuppressWarnings("resource")
				Scanner scan = new Scanner(System.in);
				String line = null;
				while (true) {
					System.out.println("Вводим строку:");
					line = scan.nextLine();
					System.out.println("Отправляем строку серверу...");
					out.writeUTF(line); // отсылаем введенную строку текста
										// серверу
					out.flush(); // очищаем поток.
					line = in.readUTF(); // ждем, пока сервер отошлет строку
											// текста
					System.out.println("Север прислал мне строку: " + line);
					System.out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
