package core.lecture3_02_Collections.example;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleQueueTest {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		queue.add("First");
		queue.add("Second");
		queue.add("Third");
		queue.add("Fourth");
		String s;
		while ((s = queue.poll()) != null)
			System.out.print(s + " "); // First Second Third Fourth
	}

}
