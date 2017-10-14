package com.javase.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassReflect {

    public static void printInfo(Class<?> c){

        String classname = c.getName();
        Field[] fields = c.getDeclaredFields();
        Method[] methods = c.getDeclaredMethods();
        Method method = null;
        try {
            Object obj = c.newInstance();
            method = c.getDeclaredMethod("printInfo");
            Method methodStatic = c.getDeclaredMethod("printStatic");
            method.invoke(obj);
            User user = (User)obj;
            user.printInfo();
            methodStatic.invoke(c);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("classname:" + classname);
        System.out.println("fields:" + Arrays.asList(fields));
        System.out.println("methods:" + Arrays.asList(methods));
        System.out.println("method:" + method);
    }


    public static void main(String[] args) {
        printInfo(User.class);
    }
}
