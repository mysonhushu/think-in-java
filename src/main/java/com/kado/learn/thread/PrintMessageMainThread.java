package com.kado.learn.thread;

public class PrintMessageMainThread {
        public static void main(String args[]) {
                for(int i=0; i<20; i++) {
                        PrintMessage printMessage = new PrintMessage();
                        System.out.println("Starting to start thread ("+printMessage.ID+")");
                        Thread thread = new Thread(printMessage);
                        thread.start();
                        System.out.println("Stared to start thread ("+printMessage.ID+")");
                }
        }
}
