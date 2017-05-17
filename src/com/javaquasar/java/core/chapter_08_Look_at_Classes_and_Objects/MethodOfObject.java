package com.javaquasar.java.core.chapter_08_Look_at_Classes_and_Objects;

/**
 * Created by Java Quasar on 16.05.17.
 */
//Object это базовый класс для всех остальных объектов в Java. 
//Каждый класс наследуется от Object. Соответственно все классы наследуют методы класса Object.
//Методы класса Object:
//public final native Class getClass() -- > Возвращает класс во время выполнения
//public native int hashCode() -- > Возвращает hash код для объекта
//public boolean equals(Object obj) -- >
//protected native Object clone() throws CloneNotSupportedException -- > Создает и возвращает копию этого объекта
//public String toString() -- > Возвращает строковое представление объекта
//public final native void notify() -- > Возобновляет единичный поток, который ожидает на объектном мониторе
//public final native void notifyAll() -- >  Возобновляет все потоки, которые ожидают на объектном мониторе
//public final native void wait(long timeout) throws InterruptedException -- > Остановка текущего потока на время или пока другой поток не вызовет notify() или notifyAll метод для этого объекта
//public final void wait(long timeout, int nanos) throws InterruptedException -- > Остановка текущего потока на время или пока другой поток не вызовет notify() или notifyAll метод для этого объекта
//public final void wait() throws InterruptedException -- > Остановка текущего потока пока другой поток не вызовет notify() или notifyAll метод для этого объекта
//protected void finalize() throws Throwable -- >  Вызывается сборщиком мусора когда нет больше ссылок на объект

/*Почему метод clone() объявлен в классе Object, а не в интерфейсе Cloneable?
 * Сам класс Object является Cloneable? Почему метод clone() объявлен, как protected? 
 * Что нужно для реализации клонирования? Какие есть альтернативы клонированию?*/

/*
 * Метод clone() объявлен в классе Object с сигнатурой native, чтобы обеспечить
 * доступ к стандартному механизму "поверхностного копирования" объектов
 * (копируются значения всех полей, включая ссылки на сторонние объекты); он
 * объявлен, как protected, чтобы нельзя было вызвать этот метод у не
 * переопределивших его объектов.
 * 
 * 
 * Интерфейс Cloneable является маркерным (не содержит объявлений методов). Он
 * нужен только для обозначения самого факта, что данный объект готов к тому,
 * чтобы быть клонированным. Вызов переопределённого метода clone() у не
 * Cloneable объекта вызовет выбрасывание CloneNotSupportedException (это
 * описано в объявлении метода).
 * 
 * Сам класс Object не является Cloneable, т.к. он является корневым классом в
 * иерархии и это привело бы к тому, что все классы являются по умолчанию
 * Cloneable.
 * 
 * Для реализации "глубокого клонирования" (когда вместо копирования ссылок на
 * содержащиеся объекты создаются новые экземпляры) необходимо самим описать
 * весь алгоритм действий в переопределённом методе clone().
 * 
 * Хорошей альтернативой сложной системе клонирования является
 * "копирующий конструктор", принимающий, в качестве параметра, экземпляр
 * собственного класса и создающий на его основе новый экземпляр.
 */

// Что нужно для реализации клонирования?

// Как минимум удовлетворить контракту этого метода:

// 1) x.clone() != x для любых x != null

// 2) возвращаемый объект:

// a) должен быть получен с помощью вызова super.clone()

// b) не должен зависить от объекта this

public class MethodOfObject {

	public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
		Object o = new Object();
		System.out.println("Получение имени класса - " + o.getClass());
		System.out.println("Получение хешкода - " + o.hashCode());
		System.out.println("Сравнение объектов - " + o.equals(o));

		MyClass mk = new MyClass();
		MyClass mkClone = mk.clone();
		System.out.println("Сравнение объектов - " + mk.equals(mkClone));
		System.out.println("Преобразование в строку - " + o);
		System.out.println("Преобразование в строку - " + o.toString());
		
		Object object = new Object();
        int hCode;
        hCode = object.hashCode();
        System.out.println(hCode);
        
        o.notify(); // IllegalMonitorStateException
        
        o.wait(); // IllegalMonitorStateException
	}
}
/*********************************************************
* Как я пытался понять смысл метода finalize из песочницы*
**********************************************************
Программирование*, JAVA*

Недавно меня пригласили в одну компанию на собеседование на должность Java-программиста. 
На собеседовании зашла речь о работе метода finalize. Я имел лишь поверхностное представление о 
работе этого метода и не смог дать достойного его описания интервьюверам. Поэтому после собеседования 
я должен был провести работу над ошибками и во всем разобраться.

Мои знания ограничивались тем, что метод finalize вызывается в момент, когда сборщик мусора начинает 
утилизировать объект. И я не совсем понимал для чего он служит. Я думал, что это что-то типа деструктора, 
в котором можно освобождать определенные ресурсы после того, как они больше не нужны, причем даже ресурсы, 
которые хранятся в других объектах, что не верно.

Так вот, первое, что требовалось понять — назначение.

Предназначен этот метод для автоматического освобождения системных ресурсов, занимаемых объектом, на котором 
будет данный метод вызван. Это кажется удобным, чтобы не помнить постоянно, например, что мы должны закрыть 
соединение с каким-то ресурсом, когда оно больше не требуется.

Не стоит полагаться на finalize для чистки данных. Во-первых, нет гарантии, что он будет вызван, т.к. где-то 
может остаться ссылка на объект. Во-вторых, нет гарантии на то, в какое время будет вызван метод. Это связано 
с тем, что после того, как объект становится доступным для сборки и, если в нем переопределен метод finalize, 
то он не вызывается сразу, а помещается в очередь, которая обрабатывается специально созданным для этого потоком. 
Стоит отметить, что в очередь на финализацию попадают только те объекты, в которых переопределен метод finalize.

Есть вероятность, что этот метод не будет вызван совсем. Это может произойти в момент, когда объект уже станет 
доступным для сборщика мусора и программа завершит свою работу.

Интересной особенностью метода является то, что он может снова сделать объект доступным, присвоив this какой-нибудь 
переменной, хотя так делать не рекомендуется, т.к. при восстановлении объекта, повторно finalize вызван не будет

Может случиться еще один редкий момент. У нас есть класс A, в котором реализован метод finalize. 
Мы создаем класс B extends A, в котором забываем про finalize. Объекты класса B содержат в себе много данных. 
Когда объекты классы B становятся ненужными, они попадут в очередь на финализацию и определенное время еще будут 
занимать память, вместо того, чтобы миновать этой очереди и сразу утилизироваться.

Еще одним недостатком является то, что надо помнить про вызов finalize-метода супер-класса, если мы переопределяем его. 
Разработчик не вызовет — никто не вызовет.

Исключения, брошенные в методе finalize, не обрабатываются потоком-финализатором, т.е. данный стектрейс скорее 
всего нельзя будет отследить.

Есть один способ быть уверенным, что finalize-методы были запущены для объектов, доступных для сборки: вызвать 
System.runFinalization() или Runtime.getRuntime().runFinalization(). Выход из метода осуществляется только тогда, 
когда все доступные методы объектов для финализации будут выполнены

Для себя я сделал вывод, что пользоваться этим методом без особой надобности не стоит, а случаи этой особой 
надобности на моей двух-с-половиной-летней практике пока не встречались.

Лучше вместо finalize писать методы типа close в java.io и вызывать их в блоке finally. Недостатком является то, 
что разработкик должен помнить, что ресурс после использования нужно закрыть. На помощь тут нам пришла Java SE 7 
со своими try-with-resources

Но ведь этот метод для чего-то есть. Где и как его можно использовать? Есть ли примеры использования?

Finalize можно использовать как последний шанс закрыть ресурс, но никогда как первая или единственная попытка. 
Т.е. в дополнение к тому, что клиент может вызвать, например, метод close на объекте, представляющем ресурс. 
А может и забыть. Тогда можно попытаться ему помочь. Так сделано, например, в классе FileInputStream.java:

protected void finalize() throws IOException {
    if ((fd != null) &&  (fd != FileDescriptor.in)) {
        
         // Finalize should not release the FileDescriptor if another
         // stream is still using it. If the user directly invokes
         // close() then the FileDescriptor is also released.
         
        runningFinalize.set(Boolean.TRUE);
        try {
            close();
        } finally {
            runningFinalize.set(Boolean.FALSE);
        }
    }
}


Данный подход часто используется в библиотеках Java.*/

