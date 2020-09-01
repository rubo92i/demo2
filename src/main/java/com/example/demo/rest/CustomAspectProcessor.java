package com.example.demo.rest;

import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;

public class CustomAspectProcessor {


    public static ApplicationContext applicationContext;

    public static void process(Class clazz) throws IllegalAccessException, InstantiationException {
        if (clazz.isAnnotationPresent(CustomController.class)){
            CustomController customController = (CustomController) clazz.getDeclaredAnnotation(CustomController.class);
            String pathStart = customController.value();
            Object instance = applicationContext.getBean(clazz);
            Method [] methods = clazz.getDeclaredMethods();
            for (Method method : methods){
                if (method.isAnnotationPresent(CustomRequestMapping.class)){
                    CustomRequestMapping customRequestMapping = method.getDeclaredAnnotation(CustomRequestMapping.class);
                    String url = pathStart + customRequestMapping.value();
                    RestContainer.urlMethod.put(url,method);
                    RestContainer.urlObject.put(url,instance);
                }
            }


        }

    }
}
