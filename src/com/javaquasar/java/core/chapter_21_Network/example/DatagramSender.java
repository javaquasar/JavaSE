package com.javaquasar.java.core.chapter_21_Network.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramSender {

	public static void main(String[] args) {
		try (DatagramSocket datagramSocket = new DatagramSocket()) {
			// Отправляемые данные должны быть представлены в виде массива
			// байтов
			byte[] buffer = "ABC".getBytes();
			InetAddress receiverAddress = InetAddress.getLocalHost();
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
					receiverAddress, 80);
			datagramSocket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
