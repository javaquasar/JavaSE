package com.javaquasar.java.core.chapter_14_Exception.checking_compile_time_and_runtime;

/**
 * Created by Java Quasar on 16.05.17.
 */

/*
Необходимо понимать, что 
— проверка на cheched исключения происходит в момент компиляции (compile-time checking)
— перехват исключений (catch) происходит в момент выполнения (runtime checking)
 */

public class Checking {
	// ТЕПЕРЬ пугаем Throwable
    public static void main(String[] args) throws Throwable { 
        try {
            Throwable t = new Exception(); // а лететь будет Exception
            throw t;
        } catch (Exception e) { // и мы перехватим Exception
            System.out.println("Перехвачено!");
        }
    }  
}

/*
class App {
    // пугаем Exception
    public static void main(String[] args) throws Exception { 
        try {
            Throwable t = new Exception(); // и лететь будет Exception
            throw t; // но тут ошибка компиляции 
        } catch (Exception e) {
            System.out.println("Перехвачено!");
        }
    }  
}
*/