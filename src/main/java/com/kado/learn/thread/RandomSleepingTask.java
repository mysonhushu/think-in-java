package com.kado.learn.thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomSleepingTask implements Runnable {
        private int randomSleepSeconds;
        private Random random = new Random();
        private int maxSleepingSeconds = 5;
        public RandomSleepingTask(){
                this.randomSleepSeconds = Math.abs(random.nextInt(maxSleepingSeconds));
        }
        public void run() {
                try {
                        TimeUnit.MILLISECONDS.sleep(randomSleepSeconds*100);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
                System.out.println("Thread "+ Thread.currentThread().getName() +" sleep "+ randomSleepSeconds +" seconds");
        }
}
