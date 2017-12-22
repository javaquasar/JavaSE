package core.lecture3_05_IO_Stream.practice.task_5_06;

/*5.6 Работа с ZIP-архивом*

Описать классы Студент и Академическая группа 
(с массивом студентов в качестве поля). 
Создать объекты Студент и Академическая группа, 
осуществить запись данных о студентах академической 
группы в архив (ZIP). 
В другой программе осуществить чтение из архива.*/

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		StoreToZip.main(args);
		ReadFromZip.main(args);
	}

}
