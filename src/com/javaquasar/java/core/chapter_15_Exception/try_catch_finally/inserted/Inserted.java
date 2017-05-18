package com.javaquasar.java.core.chapter_15_Exception.try_catch_finally.inserted;

/*Суть в том, что try-cacth-finally тоже допускает неограниченное вложение.
Например вот так*/
/**
 * Created by Java Quasar on 16.05.17.
 */
public class Inserted {
	public static void main(String[] args) {
        try {
            try {
                try {
                    //...
                } catch (Exception e) {
                } finally {}
            } catch (Exception e) {
            } finally {}
        } catch (Exception e) {
        } finally {}
    }
}

class Inserted_02 {
	public static void main(String[] args) {
        try {
            try {
                //...
            } catch (Exception e) {
                //...
            } finally {
                //...
            }
        } catch (Exception e) {
            try {
                //...
            } catch (Exception ee) {
                //...
            } finally {
                //...
            }
        } finally {
            try {
                //...
            } catch (Exception e) {
                //...
            } finally {
                //...
            }
        }
    }
}

class Inserted_03 {

}

class Inserted_04 {

}