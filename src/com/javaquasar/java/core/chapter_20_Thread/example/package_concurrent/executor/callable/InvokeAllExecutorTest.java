package com.javaquasar.java.core.chapter_20_Thread.example.package_concurrent.executor.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllExecutorTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3"
        );

        ExecutorService executor = Executors.newWorkStealingPool();
//        String result = executor.invokeAny(callables);
//        System.out.println(result);
        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

}
