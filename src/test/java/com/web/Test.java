package com.web;

import com.Demo;

import java.lang.reflect.Field;

/**
 * @author luo
 * @date 2022/12/14 18:05
 */
public class Test {
    public static void main(String[] args) {
        // 获取要检查的类的类对象
        Class<?> cls = Demo.class;

        // 获取类的所有声明字段
        Field[] fields = cls.getDeclaredFields();

        // 遍历字段并根据需要访问它们
        for (Field field : fields) {
            field.setAccessible(true);
            // 对字段执行某些操作，例如获取其名称或类型
            String fieldName = field.getName();
            Class<?> fieldType = field.getType();
            System.out.println("fieldName:" + fieldName);
            System.out.println("fieldType:" + fieldType);
        }
    }

}
