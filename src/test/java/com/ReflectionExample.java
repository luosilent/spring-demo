package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionExample {
//    首先通过 forName() 方法获取了 ArrayList 类的 Class 对象，然后通过 getName()、getModifiers()、getInterfaces()、getSuperclass() 等方法获取了类的名称、修饰符、实现的接口、父类等信息。接着通过 getConstructors()、getMethods()、getFields() 等方法获取了类的构造器、方法、字段等信息，最后通过 toString() 方法将这些信息打印出来。
    public static void main(String[] args) throws Exception {
        // 获取类的 Class 对象
        Class clazz = Class.forName("java.util.ArrayList");

        // 获取类的名称
        String className = clazz.getName();
        System.out.println("类的名称：" + className);

        // 获取类的修饰符（public、final 等）
        int modifiers = clazz.getModifiers();
        System.out.println("类的修饰符：" + Modifier.toString(modifiers));

        // 获取类实现的接口
        Class[] interfaces = clazz.getInterfaces();
        System.out.println("类实现的接口：");
        for (Class c : interfaces) {
            System.out.println("  " + c.getName());
        }

        // 获取类的父类
        Class superclass = clazz.getSuperclass();
        System.out.println("类的父类：" + superclass.getName());

        // 获取类的构造器
        Constructor[] constructors = clazz.getConstructors();
        System.out.println("类的构造器：");
        for (Constructor c : constructors) {
            System.out.println("  " + c.toString());
        }
        // 获取类的方法
        Method[] methods = clazz.getMethods();
        System.out.println("类的方法：");
        for (Method m : methods) {
            System.out.println("  " + m.toString());
        }

        // 获取类的字段
        Field[] fields = clazz.getFields();
        System.out.println("类的字段：");
        for (Field f : fields) {
            System.out.println("  " + f.toString());
        }
    }
}

