package com.javaquasar.java.core.chapter_20_Thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by Java Quasar on 16.05.17.
 */
//На данный момент рекомендуется использовать не Thread.sleep, а TimeUnit
public class Sleep {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 1; i < 60; i++) {
            System.out.println(i);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
