package com.kado.learn.thread;

public class MainThread {
        public static void main(String args[]) {
                for(int i=0; i<10; i++) {
                        LiftOff liftOff = new LiftOff();
                        Thread thread = new Thread(liftOff);
                        thread.start();
                }
        }
}
