package core.lecture3_08_Reflection.practice.task_7_06;

/*7.6 Вызов метода, помеченного аннотацией*

Модифицировать пример 6.5 так, чтобы метод вызывался только если сам класс 
помечен аннотацией @Contains и значение свойства run аннотации @ToInvoke 
равно true (соответствующую аннотацию необходимо модифицировать).s*/

import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)

public @interface ToInvoke {
	public boolean run() default false;	
}
