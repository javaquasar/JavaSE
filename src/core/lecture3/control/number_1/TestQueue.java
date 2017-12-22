package core.lecture3.control.number_1;

public class TestQueue {
	public static void main(String[] args) {
		MyQueue<String> queue = new MyQueue<>(5);
		System.out.println(queue);
		System.out.println("empty = " + queue.isEmpty() + " full = " + queue.isFull());
        System.out.println("--------------Добавление-------------");
		
		System.out.println(queue.offer("а") + " Добавление start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println(queue.offer("б") + " Добавление start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println(queue.offer("в") + " Добавление start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println(queue.offer("г") + " Добавление start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println(queue.offer("д") + " Добавление start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println("empty = " + queue.isEmpty() + " full = " + queue.isFull());
		queue.print();
		System.out.println("size = " + queue.size());
		queue.poll();
		System.out.println("size = " + queue.size());
		System.out.println(queue);
		queue.print();
		System.out.println(queue.offer("Ё"));
		System.out.println("size = " + queue.size());
		System.out.println(queue);
		
		System.out.println("--------------Очистка-------------");
		
		System.out.println(queue.poll() + " Очистка start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println(queue.poll() + " Очистка start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println(queue.poll() + " Очистка start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println(queue.poll() + " Очистка start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println(queue.poll() + " Очистка start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println("empty = " + queue.isEmpty() + " full = " + queue.isFull());
		System.out.println(queue);
		
		System.out.println("--------------Добавление-------------");
		
		System.out.println("size = " + queue.size());
		System.out.println(queue.offer("а") + " Добавление start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println(queue.offer("б") + " Добавление start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println(queue.offer("в") + " Добавление start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println(queue.offer("г") + " Добавление start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println(queue.offer("д") + " Добавление start = " + queue.getStart() + " end = " + queue.getEnd());
		System.out.println("empty = " + queue.isEmpty() + " full = " + queue.isFull());
		System.out.println(queue);
		System.out.println(queue.offer("Ё"));
	}
}
