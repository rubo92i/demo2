package com.example.demo.rest;

import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RestContainer {


    public static final Map<String, Object> urlObject = new HashMap<>();

    public static final Map<String, Method> urlMethod = new HashMap<>();



    public static ResponseEntity invokeInternal(String url, Object variables){
        try {
            Method method = urlMethod.get(url);
            return (ResponseEntity) method.invoke(urlObject.get(url),variables);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
