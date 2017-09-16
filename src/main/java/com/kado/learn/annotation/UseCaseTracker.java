package com.kado.learn.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
        public static void trackUserCases(List<Integer> useCases, Class<?> cl) {
                for (Method m : cl.getDeclaredMethods()) {
                        UseCase useCase = m.getAnnotation(UseCase.class);
                        if(useCase != null) {
                                System.out.println("Found Use Case:" + useCase.id() + " " + useCase.description());
                                useCases.remove(new Integer(useCase.id()));
                        } else {
                                System.out.println("useCase is null!");
                        }
                }
                for(int i : useCases) {
                        System.out.println("Warning: Missing use case-" + i);
                }
        }

        public static void main(String[] args){
                List<Integer> useCases = new ArrayList<Integer>();
                Collections.addAll(useCases, 47, 48, 49, 50);
                trackUserCases(useCases, PasswordUtils.class);
        }
}
