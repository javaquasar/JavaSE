package com.javaquasar.java.core.chapter_21_Network;

import java.net.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class GetIPAddress {
	public static void main(String[] args) {
		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
			System.out.println("Google: " + addr.getHostAddress());
			// вывод IP-адреса
			addr = InetAddress.getByName("google.com");
			System.out.println("Google: " + addr.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
