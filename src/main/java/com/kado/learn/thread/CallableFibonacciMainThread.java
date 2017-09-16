package com.kado.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFibonacciMainThread {
        public static  void main(String args[]) {
                ExecutorService executorService = Executors.newCachedThreadPool();
                List<Future<String>> resutls = new ArrayList<Future<String>>();
                for(int i=0; i<30; i++) {
                        CallableFibonacci callableFibonacci = new CallableFibonacci(i);
                        resutls.add(executorService.submit(callableFibonacci));
                }
                executorService.shutdown();
                for(Future<String> future : resutls) {
                        if(future.isDone()) {
                                try {
                                        System.out.println(future.get());
                                } catch (InterruptedException e) {
                                        e.printStackTrace();
                                } catch (ExecutionException e) {
                                        e.printStackTrace();
                                }
                        }
                }
        }
}
