package core.lecture3_02_Collections.practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*6.2 Среднее арифметическое*

Реализовать программу, в которой вводятся вещественные числа, выводятся в порядке 
возрастания модулей, а также вычисляется их среднее арифметическое. 
Использовать PriorityQueue.*/

public class ArithmeticAverageWithLamda {

	public static void main(String[] args) {
		
		Queue<Double> queue = new PriorityQueue<>((i1, i2) ->  Double.compare(Math.abs(i1), Math.abs(i2)));
		
		queue.add(-9.0);
		queue.add(10.1);
		queue.add(-7.9);
		queue.add(6.7);
		queue.add(11.0);
		
		Double d;
		double tempSum = 0.0;
		int size = queue.size();
		while ((d = queue.poll()) != null) {
			tempSum =+ d;
			System.out.print(d + " ");
		}
		System.out.println();
		
		System.out.println("Сумма равна = " + tempSum);
		System.out.println("Среднее арифметическое = " + tempSum/size);

	}

}
