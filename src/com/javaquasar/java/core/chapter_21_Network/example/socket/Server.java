package com.javaquasar.java.core.chapter_21_Network.example.socket;

import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) {
		int port = 7777; // случайный порт (может быть любое число от 1025 до
							// 65535)
		// Создаем сокет сервера и привязываем его к вышеуказанному порту:
		try (ServerSocket ss = new ServerSocket(port)) {
			System.out.println("Ожидаем клиента...");
			// Сервер ждет подключений:
			Socket socket = ss.accept();
			System.out.println("Клиент нашелся!");
			System.out.println();

			// Получаем входной и выходной потоки сокета
			// Теперь можем получать и отсылать данные клиенту:
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(
					socket.getOutputStream());

			String line = null;
			while (true) {
				line = in.readUTF(); // ожидаем пока клиент пришлет строку
										// текста
				System.out.println("Клиент отправил мне строку: " + line);
				System.out.println("Я отправляю ее обратно...");
				out.writeUTF(line); // отсылаем клиенту обратно ту самую строку
									// текста
				out.flush(); // освобождаем буфер потока
				System.out.println("Ожидаю следующую строку...");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
