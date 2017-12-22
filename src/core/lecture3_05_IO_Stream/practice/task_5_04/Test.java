package core.lecture3_05_IO_Stream.practice.task_5_04;

/*5.4 Реализация сериализации и десериализации*

Описать классы Студент и Академическая группа 
(с массивом студентов в качестве поля). 
Создать объекты, осуществить их сериализацию и десериализацию.*/

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		DataSerialization.main(args);
		DataDeserialization.main(args);
	}

}
