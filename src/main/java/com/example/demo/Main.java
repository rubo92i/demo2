package com.example.demo;


import com.example.demo.model.Card;
import com.example.demo.model.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Object object = createObject(Singleton.class);
        Object object2 = createObject(Singleton.class);
        System.out.println(object);
        System.out.println(object2);

        Card card = new Card();
        card.setNumber("1561561");


        System.out.println(getFieldValue(card, "number"));


    }


    public static <T extends Number> T test(T t) {
        return t;
    }


    public static Object createObject(Class clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }


    public static Object getFieldValue(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

    public static void setFieldValue(Object object, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }
}
