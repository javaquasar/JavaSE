package core.lecture3_08_Reflection.practice.kv;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Vitaliy on 21.01.15.
 */

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface ToInvoke {
    boolean run();
}

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Contains{
}

@Contains
class ATest {

    public void aFirst() {
        System.out.println("aFirst launched");
    }

    @ToInvoke(run = true)
    public void aSecond() {
        System.out.println("aSecond launched");
    }

    public void aThird() {
        System.out.println("aThird launched");
    }
}

class BTest {

    @ToInvoke(run = false)
    public void bFirst() {
        System.out.println("bFirst launched");
    }

    public void bSecond() {
        System.out.println("bSecond launched");
    }

    @ToInvoke(run = true)
    public void bThird() {
        System.out.println("bThird launched");
    }

}

@Contains
class CTest {

    @ToInvoke(run = true)
    public void cFirst() {
        System.out.println("cFirst launched");
    }

    @ToInvoke(run = false)
    public void cSecond() {
        System.out.println("cSecond launched");
    }


    public void cThird() {
        System.out.println("cThird launched");
    }

}


public class AnnotationMethod {
    static void invokeFromClass(String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> myClass = Class.forName(str);
        if(myClass.isAnnotationPresent(Contains.class)){
            Method[] methods = myClass.getMethods();
            for (Method method : methods) {
                if(method.isAnnotationPresent(ToInvoke.class)){
                    if(method.getAnnotation(ToInvoke.class).run() == true){
                        method.invoke(myClass.newInstance());
                    }
                }
                else
                    System.out.println("No annotation before " + method.getName());
            }
        }
        else{
            System.out.println("Class: " + myClass.getName() + " haven't @Contains annotation...");
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        invokeFromClass("reflection.ATest");
        System.out.println("--------------");
        invokeFromClass("reflection.BTest");
        System.out.println("--------------");
        invokeFromClass("reflection.CTest");
    }
}
