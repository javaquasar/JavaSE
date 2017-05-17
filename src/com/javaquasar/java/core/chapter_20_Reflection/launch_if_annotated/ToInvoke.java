package com.javaquasar.java.core.chapter_20_Reflection.launch_if_annotated;

import java.lang.annotation.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ToInvoke {
}
