package com.javaquasar.java.core.chapter_21_Network.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramReceiver {

	public static void main(String[] args) {
		try (DatagramSocket datagramSocket = new DatagramSocket(80)) {
			byte[] buffer = new byte[100];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			datagramSocket.receive(packet);
			// Выделяем существенные данные исходя из реальной длины пакета
			String result = new String(buffer).substring(0, packet.getLength());
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
