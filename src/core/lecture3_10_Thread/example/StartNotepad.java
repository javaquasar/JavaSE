package core.lecture3_10_Thread.example;

public class StartNotepad {

	public static void main(String[] args) throws java.io.IOException {
		String[] command = { "notepad" };
		// в массиве также могут быть аргументы
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		processBuilder.start();
	}

}
