package com.kado.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
        public void run() {
                while(countDown-- >0) {
                        System.out.print(getStatus());
                        try {
                                TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                                System.out.println(e);
                                e.printStackTrace();
                        }
                }
        }
        public static void main(String args[]) {
                ExecutorService executorService = Executors.newCachedThreadPool();
                for(int i=0; i<10; i++) {
                        SleepingTask sleepingTask = new SleepingTask();
                        executorService.execute(sleepingTask);
                }
                executorService.shutdown();
        }
}
