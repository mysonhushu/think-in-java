package com.kado.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimplePriority implements Runnable {
        public int countDown = 5;
        private volatile double d; // make sure compile no optimization
        private int priority;
        public SimplePriority(int priority) {
                this.priority = priority;
        }

        public String toString() {
                return Thread.currentThread() + ": " + countDown;
        }
        public void run() {
                Thread.currentThread().setPriority(priority);
                while (true) {
                        int i=1;
                        // An expensive, interruptable operation.
//                        for (int i = 1; i < 100000; i++) {
                                d += (Math.PI + Math.E) / (double)i;
                                if(i %1000 == 0) {
                                        Thread.yield();
                                }
//                        }
                        System.out.println(this);
                        if(--countDown == 0) {
                                return;
                        }
                }
        }

        public static void  main(String[] args) {
                ExecutorService executorService = Executors.newCachedThreadPool();
                for(int i=0; i<5; i++) {
                        executorService.execute(new SimplePriority(Thread.MIN_PRIORITY));
                }
                executorService.execute(new SimplePriority(Thread.MAX_PRIORITY));
        }
}
