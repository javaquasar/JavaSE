package core.lecture3_02_Collections.example;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("First");
		stack.push("Second");
		stack.push("Third");
		stack.push("Fourth");
		String s;
		while (!stack.isEmpty()) {
			s = stack.pop();
			System.out.print(s + " "); // Fourth Third Second First
		}
	}

}
