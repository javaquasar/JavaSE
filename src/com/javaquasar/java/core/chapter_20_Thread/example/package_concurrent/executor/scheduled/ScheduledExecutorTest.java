package com.javaquasar.java.core.chapter_20_Thread.example.package_concurrent.executor.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());

        int initialDelay = 0;
        int period = 1;
        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);

        //executor.scheduleWithFixedDelay(); нужен если задача длиться дольше интервала расписания

        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);
        TimeUnit.MILLISECONDS.sleep(1337);
        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms", remainingDelay);
    }
}
