package com.kado.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RandomSleepingMainThread {
        public static void main(String args[]) {
                ExecutorService executorService = Executors.newCachedThreadPool();
                for(int i=0; i<10; i++) {
                        RandomSleepingTask randomSleepingTask = new RandomSleepingTask();
                        executorService.execute(randomSleepingTask);
                }
                executorService.shutdown();
        }
}
