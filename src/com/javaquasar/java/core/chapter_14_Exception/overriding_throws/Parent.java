package com.javaquasar.java.core.chapter_14_Exception.overriding_throws;

import java.io.FileNotFoundException;
import java.io.IOException;
/*
При переопределении (overriding) список исключений потомка не обязан совпадать с таковым у предка. 
Но он должен быть «не сильнее» списка предка:
 */
/**
 * Created by Java Quasar on 16.05.17.
 */
public class Parent {
    // предок пугает IOException и InterruptedException
    public void f() throws IOException, InterruptedException {}
}

class Child extends Parent {
    // а потомок пугает только потомком IOException
    @Override
    public void f() throws FileNotFoundException {}
}
