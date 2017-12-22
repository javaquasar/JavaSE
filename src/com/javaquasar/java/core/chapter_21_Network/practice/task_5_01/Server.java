package com.javaquasar.java.core.chapter_21_Network.practice.task_5_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        int port = 7777; // случайный порт (может быть любое число от 1025 до 65535)
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
           DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String line = null;


            @SuppressWarnings("resource")
            Scanner scan = new Scanner(System.in);
            while (true) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста
                System.out.println(line);
                System.out.println("Введите сообщение:");
                String lineForWrite = null;
                lineForWrite = scan.nextLine();
                System.out.println();
                out.writeUTF(lineForWrite); // отсылаем клиенту обратно ту самую строку текста
                out.flush(); // освобождаем буфер потока

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
