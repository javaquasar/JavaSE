package core.lecture3_08_Reflection.practice.kv;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by Vitaliy on 21.01.15.
 */
public class DeclaredFields {
    public static void main(String[] args) throws ClassNotFoundException {
        String nameOfClass = new Scanner(System.in).next();
        Class<?> myClass = Class.forName(nameOfClass);
        Field[] declaredFields = myClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("name = "+ field.getName() + "; type = "+ field.getType());
        }
//        Method[] m = myClass.getMethods();
//        for (Method method : m) {
//            System.out.println(method.getName());
//        }
    }
}
