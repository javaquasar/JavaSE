package com.javaquasar.java.core.chapter_20_Thread.example.package_concurrent.executor.callable;

import java.util.concurrent.*;

public class FixedThreadPoolExecutorTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Callable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

//        executor.shutdownNow();
//        future.get(); // бросит исключение

        System.out.println("future done? " + future.isDone());
        //Integer result = future.get();
        Integer result = future.get(1, TimeUnit.SECONDS);
        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);
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
