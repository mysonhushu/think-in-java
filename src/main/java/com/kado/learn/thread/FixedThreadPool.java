package com.kado.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
        public static void main(String args[]) {
                ExecutorService exec = Executors.newFixedThreadPool(5);
                for(int i=0; i<10; i++) {
                        Fibonacci fibonacci = new Fibonacci(i);
                        exec.execute(fibonacci);
                }
                exec.shutdown();
        }
}
