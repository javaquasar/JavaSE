package core.lecture3_03_Own_containers.practice.flexible_array;

public class Test {
	public static void main(String[] args) {
		FlexArray<Integer> integers = new FlexArray<>();
		Integer[] integers1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		integers.setArr(integers1);
		integers.set(15, 100);
		System.out.println(integers.size());
		for (Integer integer : integers) {
			System.out.print(integer + " ");
		}
		System.out.println();
		integers.set(20, 1000);
		System.out.println(integers.size());
		System.out.println(integers);
	}
}
