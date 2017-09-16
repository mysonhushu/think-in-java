package com.kado.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
        public static void main(String args[]) {
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                for(int i=0; i<10; i++) {
                        Fibonacci fibonacci = new Fibonacci(i);
                        executorService.execute(fibonacci);
                }
                executorService.shutdown();
        }
}
