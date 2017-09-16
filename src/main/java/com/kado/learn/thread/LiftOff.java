package com.kado.learn.thread;

public class LiftOff implements Runnable {
        //private final int THREAD_ID;
        protected int countDown = 10;
        private static  int taskCount = 0;
        public final int id = taskCount ++;
        public LiftOff() {
        }
        public String getStatus() {
                return "#" + id + "(" +
                       (countDown > 0 ? countDown : "LiftOff!") + "),";
        }
        public void run() {
                while (countDown-- >0) {
                        System.out.print(getStatus());
                        Thread.yield();
                }
        }
}
