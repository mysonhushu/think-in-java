package com.kado.learn.thread;

import net.mindview.util.Generator;

public class Fibonacci implements Generator<Integer>, Runnable{
        private static int taskCount = 0;
        private final int ID = taskCount++;
        private  int count = 0;
        private int fibCount;
        public Fibonacci(int fibCount) {
                this.fibCount = fibCount;
        }
        public Integer next() {
                return fib(count++);
        }
        private int fib(int n) {
                if(n == 0 || n == 1) {
                        return n;
                } else {
                        return fib(n-1) + fib(n-2);
                }
        }

        private void getFibonacciArray() {
                StringBuffer stringBuffer = new StringBuffer();
                for(int i=0; i< fibCount; i++) {
                        stringBuffer.append("ID("+ID+")"+this.next() + " ");
                }
                System.out.println(stringBuffer.toString());
        }

        public void run() {
                System.out.println("Thread ID:"+ Thread.currentThread().getName()+" Task ID" + ID+" generate Fibonacci:");
                this.getFibonacciArray();
        }
}
