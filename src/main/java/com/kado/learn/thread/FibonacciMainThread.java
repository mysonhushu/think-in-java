package com.kado.learn.thread;

public class FibonacciMainThread  {
        public  static  void main(String args[]) {
                for(int i=0; i<30; i++) {
                        Fibonacci fibonacci = new Fibonacci(i);
                        Thread thread = new Thread(fibonacci);
                        thread.start();
                }
        }
}
