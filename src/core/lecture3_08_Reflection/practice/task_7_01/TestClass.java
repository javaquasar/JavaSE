package core.lecture3_08_Reflection.practice.task_7_01;

public class TestClass {
	
	public int a = 0;
	private int k = 0;
	
	public void testPublic() {
		
	}

	private void testPrivate() {
		System.out.println("Закрытый метод. k = " + k);
	}
}
