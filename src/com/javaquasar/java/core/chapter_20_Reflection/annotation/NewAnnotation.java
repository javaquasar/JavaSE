package com.javaquasar.java.core.chapter_20_Reflection.annotation;

import java.lang.annotation.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface NewAnnotation {
	int firstValue();

	String secondValue() default "second";
}
