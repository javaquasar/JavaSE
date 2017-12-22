package core.lecture3_10_Thread.example;

public class ThreadTest extends Thread {

	@Override
	public void run() {
		for (int counter = 1; counter <= 10; counter++) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(counter);
		}
	}

	public static void main(String[] args) {
		new ThreadTest().start();
		// Сюда можно добавить действия, выполняемые параллельно с методом run()
	}

}
