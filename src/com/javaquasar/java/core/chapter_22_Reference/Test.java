package com.javaquasar.java.core.chapter_22_Reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Test {

	// сильные ссылки
	List<BigObject> strongList;
	// мягкие ссылки
	List<Reference<BigObject>> softList;
	// слабые ссылки
	List<Reference<BigObject>> weakList;
	// фантомные ссылки
	List<Reference<BigObject>> phantomList;
	// очередь
	ReferenceQueue<BigObject> queue;
	// здесь будут храниться ссылки на строки, которые используются для
	// загрузки памяти
	List<String> loadMemoryList;

	public static void main(String[] args) {
		Test test = new Test();
		test.testPhantomReferences();
	}

	// Методы инициализации и загрузки памяти выглядят так:
	private void init() {
		strongList = new ArrayList<BigObject>();
		softList = new ArrayList<Reference<BigObject>>();
		weakList = new ArrayList<Reference<BigObject>>();
		phantomList = new ArrayList<Reference<BigObject>>();
		loadMemoryList = new ArrayList<String>();
		queue = new ReferenceQueue<BigObject>();
		for (int i = 0; i < 3; i++) {
			strongList.add(new BigObject(i));
			softList.add(new SoftReference<BigObject>(new BigObject(i)));
			weakList.add(new WeakReference<BigObject>(new BigObject(i)));
			phantomList.add(new PhantomReference<BigObject>(new BigObject(i), queue));
		}
		printLists();
	}

	private void loadMemory() {
		for (int i = 0; i < 1200000; i++) {
			loadMemoryList.add(i + "");
		}
	}

	// Для вывода результатов тестов будем использовать следующие методы:
	private void printLists() {
		System.out.println("Strong references: ");
		for (BigObject bo : strongList) {
			System.out.print(bo + " ");
		}
		System.out.println();
		System.out.println("SoftReferences: ");
		printList(softList);
		System.out.println("WeakReferences: ");
		printList(weakList);
		System.out.println("PhantomReferences: ");
		printList(phantomList);
	}

	private void printList(List<Reference<BigObject>> pList) {
		for (Reference<BigObject> ref : pList) {
			System.out.print(ref.get() + " ");
		}
		System.out.println();
	}

	// Теперь проведем тестирование. Для первого теста используем следующий код:

	public void testPhantomReferences() {
		init(); // инициализация
		System.gc(); // вызов сборщика мусора
		System.out.println("garbage collector invoked");
		printLists(); // вывод

		// В результате получаем:

		// Strong references:
		// 0 1 2
		// SoftReferences:
		// 0 1 2
		// WeakReferences:
		// 0 1 2
		// PhantomReferences:
		// null null null
		// garbage collector invoked
		// Strong references:
		// 0 BigObject (2) finalize()
		// BigObject (2) finalize()
		// BigObject (1) finalize()
		// BigObject (1) finalize()
		// BigObject (0) finalize()
		// BigObject (0) finalize()
		// 1 2
		// SoftReferences:
		// 0 1 2
		// WeakReferences:
		// null null null
		// PhantomReferences:
		// null null null

		/*
		 * Пояснение: Как ранее говорилось, фантомные ссылки всегда возвращают
		 * null. После вызова сборщика мусора были удалены объекты на которые
		 * ссылались фантомные ссылки (PhantomReference) и слабые ссылки
		 * (WeakReference).
		 */
	}

	// Во втором тесте рассмотрим момент удаления объектов на которые ссылаются
	// мягкие ссылки (SoftReference). Тест представлен кодом:
	public void testSoftRefences() {
		init();
		System.gc();
		System.out.println("garbage collector invoked");
		printLists();
		System.out.println("memory usage increased");
		loadMemory(); // загрузка памяти
		System.out.println("loadMemoryList.size() = " + loadMemoryList.size());
		System.gc();
		System.out.println("garbage collector invoked");
		printLists();

		// В результате получаем:
		//
		//
		// Strong references:
		// 0 1 2
		// SoftReferences:
		// 0 1 2
		// WeakReferences:
		// 0 1 2
		// garbage collector invoked
		// Strong references:
		// BigObject (2) finalize()
		// BigObject (1) finalize()
		// BigObject (0) finalize()
		// 0 1 2
		// SoftReferences:
		// 0 1 2
		// WeakReferences:
		// null null null
		// memory usage increased
		// loadMemoryList.size() = 1200000
		// garbage collector invoked
		// BigObject (2) finalize()
		// BigObject (1) finalize()
		// BigObject (0) finalize()
		// Strong references:
		// 0 1 2
		// SoftReferences:
		// null null null
		// WeakReferences:
		// null null null

		/*
		 * Пояснение: На первом этапе после вызова сборщика мусора были удалены
		 * объекты на которые указывали слабые ссылки (WeakReference). Далее
		 * происходит загрузка памяти и повторный вызов сборщика мусора. После
		 * этого удаляются объекты на которые указывали мягкие ссылки
		 * (SoftReference). В результате после этих действий остались объекты
		 * только с прямыми (сильными) ссылками на них.
		 * 
		 * Выводы
		 * 
		 * Использование различных видов ссылок в Java позволяет уменьшить
		 * вероятность возникновения утечек памяти (memory leaks), а также
		 * повысить эффективность использования памяти. Для реализации кеша
		 * можно использовать класс WeakHashMap.
		 */
	}

}

/*
 * Виды ссылок на объекты в Java
 * 
 * В данной статье рассматривается использование классов из стандартного пакета
 * java.lang.ref, таких как SoftReference, WeakReference, PhantomReference.
 * 
 * Рассмотрим пример когда эти классы могут понадобиться.
 * 
 * Есть такая задача: необходимо реализовать загрузку объектов с серверной
 * стороны на клиентскую сторону по требованию клиента. Для этого можно
 * реализовать коллекцию объектов на клиенте, в которой будут сохраняться уже
 * загруженные объекты, для того чтобы при повторном запросе этого же объекта не
 * приходилось загружать его снова, а отдавать их из этой коллекции, т.е.
 * реализация кеша на клиенте. С течением времени клиент загрузит много новых
 * объектов, сохранит их в коллекцию, а ранее загруженные объекты становятся уже
 * не актуальными и просто занимают место в памяти. Итого - необходим механизм
 * очистки кеша.
 * 
 * Здесь можно пойти разными путями, рассмотрим некоторые:
 * 
 * 1. можно следить за тем, когда объект перестает использоваться на клиенте и
 * затем удалять его из коллекции. Однако, это решение требует многих изменений
 * в логике работы клиента, и будет идеально чтобы другие классы работали с
 * этими объектами прозрачно.
 * 
 * 2. Использовать механизм "слабых ссылок" в Java.
 * 
 * Что это за "слабые ссылки"?
 * 
 * В Java ссылки можно разделить по "силе". Далее представлены все 4 типа ссылок
 * отсортированных по "силе" (от большей к меньшей):
 * 
 * 1. сильные ссылки (strong reference). Это обычные ссылки которые мы всегда
 * используем. Когда мы объявляем Rectangle rect = new Rectangle(), то объект на
 * который ссылается rect не может быть удален сборщиком мусора из памяти до тех
 * пор, пока на этот объект есть хотя бы одна сильная ссылка;
 * 
 * 2. мягкие ссылки (SoftReference). Объявление мягкой ссылки выглядит так:
 * 
 * SoftReference<Rectangle> rect = new SoftReference<Rectangle>(new
 * Rectangle());
 * 
 * Для получения самого объекта Rectangle можно воспользоваться методом
 * rect.get(). Метод get() объявлен у класса Reference, от которого наследуются
 * SoftReference, WeakReference, PhantomReference. Важно понимать, что метод
 * get() может вернуть null. Это происходит в том случае, когда память вашей
 * программы заполнена и появляется вероятность возникновения OutOfMemoryError,
 * тогда сборщик мусора удаляет объекты на которые ссылаются мягкие ссылки.
 * Именно этот вид ссылок удобно использовать для кеширования объектов.
 * 
 * 3. слабые ссылки (WeakReference). Использование слабой ссылки схоже с
 * использованием мягкой ссылки, объявление:
 * 
 * WeakReference<Rectangle> rect = new WeakReference<Rectangle>(new
 * Rectangle());
 * 
 * Разница в том, что объект на который ссылается слабая ссылка может быть
 * удален в любой момент при вызове cборщика мусора, т.е. для этого не
 * обязательно условие нехватки памяти.
 * 
 * 4. фантомные ссылки (PhantomReference). Создание фантомной ссылки аналогично
 * другим:
 * 
 * PhantomReference<Rectangle> rect =
 * 
 * new PhantomReference<Rectangle>(new Rectangle(), queue);
 * 
 * Разница в том, что здесь обязательно объявление объекта очереди queue - это
 * представитель класса ReferenceQueue. Очереди используются также с
 * SoftReference и WeakReference. Их функция в том, что когда объект доступный с
 * помощью ссылки удаляется, то сам объект ссылки становится доступным в очереди
 * ReferenceQueue. Этот механизм позволяет удалять пустые ссылки.
 * 
 * Метод get() вызванный у фантомной ссылки всегда возвращает null. Это связано
 * с тем для чего они используются.
 * 
 * Дело в том, что слабая ссылка помещается в очередь перед тем, как объект на
 * который она указывает будет финализирован (finalize()) и удален сборщиком
 * мусора. Т.е. в методе finalize() удаляемого объекта можно назначить строгую
 * ссылку на удаляемый объект, и таким образом "спасти" его от сборщика мусора.
 * Но слабая ссылка уже будет в очереди и будет уничтожена.
 * 
 * Отличие фантомной ссылки в том, что она помещается в очередь только
 * "по факту" удаления объекта на который она указывает - это и есть её основная
 * функция.
 * 
 * Рассмотрим слабые ссылки на практическом примере.
 * 
 * Объекты на которые будут указывать наши ссылки представлены классом
 * BigObject.
 */
