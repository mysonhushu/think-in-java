package com.kado.learn.thread;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
        public static void main(String args[]) {
                ExecutorService executorService = Executors.newCachedThreadPool();
                ArrayList<Future<String>> results = new ArrayList<Future<String>>();
                for(int i=0; i<10; i++) {
                        results.add(executorService.submit(new TaskWithResult(i)));
                }
                for(Future<String> future : results) {
                        try {
                                System.out.print("---huxing---"+future.get());
                        } catch (InterruptedException e) {
                                System.out.println(e);
                                e.printStackTrace();
                        } catch (ExecutionException e) {
                                System.out.println(e);
                                e.printStackTrace();
                        } finally {
                                executorService.shutdown();
                        }
                }

        }
}
