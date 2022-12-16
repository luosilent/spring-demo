package com;

import example.patterns.factory.Shape;
import example.patterns.factory.ShapeFactory;

/**
 * @author com.luo.prodemo.luo
 * @date 2022/12/8 11:16
 */
public class ShapeFactoryTest {
    public static void main(String[] args) throws Exception {
        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.getShape("CIRCLE");
        circle.draw(); // 输出 "Drawing circle..."

        Shape rectangle = factory.getShape("RECTANGLE");
        rectangle.draw(); // 输出 "Drawing rectangle..."
    }
}
