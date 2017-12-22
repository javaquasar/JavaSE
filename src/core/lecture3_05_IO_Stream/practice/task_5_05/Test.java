package core.lecture3_05_IO_Stream.practice.task_5_05;

/*5.5 Сериализация и десериализация объектов обобщенных классов*

Описать классы "Учебное заведение" и "Массив" (обобщенный класс). 
Создать массив объектов "Учебное заведение", осуществить сериализацию 
и десериализацию.*/

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		DataSerialization.main(args);
		DataDeserialization.main(args);
	}

}
