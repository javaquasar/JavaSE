package com.javaquasar.java.core.chapter_20_Thread.base.modifier_volatile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Java Quasar on 29.05.17.
 */
public class TaskRunner {

    /*
    Атомарные операции - это операции, которые не могут быть прерваны планировщиком потоков.
    Чтение и запись примитивных переменных кроме double и long являются атомарными.
    Даже если операция является атомарной, значение переменной может хранится в кэше ядра, и быть не видным другому
    потоку, поэтому для обеспечение видимости внутри приложения существует ключевое слово volatile.
    Но данное ключевое слово не обеспечивает атомарности операциям, не смотря на то что после записи, значение поле
    будет отображено сразу при всех операциях чтения.
     */
    private static final int countThreads = 20 * Runtime.getRuntime().availableProcessors();
    private static final int countLoops = 100;

    private static volatile long flag = 0;
    private static AtomicLong flagAtomic = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        System.out.println("Available Processors = " + Runtime.getRuntime().availableProcessors());
        System.out.println("Count threads = " + countThreads);
        List<Thread> listThread = new ArrayList<>();
        for (int i = 0; i < countThreads; i++) {
            listThread.add(new Thread(new Task(i)));
        }

        for (Thread t : listThread) {
            //t.setDaemon(true);
            t.start();
        }

        for(Thread t : listThread) {
            if(t.isAlive()) {
                t.join();
            }
        }
        //TimeUnit.SECONDS.sleep(10);
        System.out.println("flag and flagAtomic must be " + countThreads * countLoops);
        System.out.println("flag = " + flag);
        System.out.println("flagAtomic = " + flagAtomic);
        System.out.println("flagAtomic == flag = " + (flagAtomic.get() == flag));
    }

    static class Task implements Runnable {

        private int number;

        public Task(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            int i = 0;

            while (i < countLoops) {
                i++;
                flag++;
                if(flag < 0 || flag > countLoops * countThreads) {
                    System.out.println("Error flag = " + flag);
                }
                flagAtomic.addAndGet(1);
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    System.out.println(number + "does not sleep");;
                }
            }
        }
    }
}
