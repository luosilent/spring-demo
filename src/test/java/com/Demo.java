package com;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author com.luo.prodemo.luo
 * @date 2022/9/9 10:56
 */
public class Demo {
    public int demo1 = 1;
    private String demo2 = "1";
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        // 获取 String 类的 Class 对象
        Class<String> stringClass = String.class;

        // 获取 String 类中名称为 "length" 的方法
        Method lengthMethod = stringClass.getMethod("length");

        // 调用字符串 "hello" 的 length() 方法
        Object result = lengthMethod.invoke("hello");

        // 输出结果，应该是 5
        System.out.println(result);

    }
}
