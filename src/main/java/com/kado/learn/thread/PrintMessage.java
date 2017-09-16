package com.kado.learn.thread;

public class PrintMessage implements Runnable {
        private static int countId = 0;
        public final int ID = countId++;

        public void run() {
                System.out.println("(" + ID+")Begin to print  first message");
                Thread.yield();
                System.out.println("(" + ID+")Begin to print second message");
                Thread.yield();
                System.out.println("(" + ID+")Begin to print third message");
        }


}
