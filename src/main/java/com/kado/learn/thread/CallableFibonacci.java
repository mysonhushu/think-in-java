package com.kado.learn.thread;

import java.util.concurrent.Callable;

public class CallableFibonacci implements Callable<String> {
        protected int fibonacciArraySize;

        public CallableFibonacci(int fibonacciArraySize) {
                this.fibonacciArraySize = fibonacciArraySize;
        }

        protected int getFibonacci(int n) {
                if(n==0 || n==1) {
                        return n;
                } else {
                        return getFibonacci(n-1) + getFibonacci(n-2);
                }
        }

        public String call() throws Exception {
                StringBuffer stringBuffer = new StringBuffer();
                for(int i=0; i< fibonacciArraySize; i++) {
                        stringBuffer.append(getFibonacci(i)+ " ");
                }
                return stringBuffer.toString();
        }
}
