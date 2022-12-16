package example.patterns.factory;

/**
 * @author com.luo.prodemo.luo
 * @date 2022/12/8 11:16
 */
public class ShapeFactoryTest {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.getShape("CIRCLE");
        circle.draw(); // 输出 "Drawing circle..."

        Shape rectangle = factory.getShape("RECTANGLE");
        rectangle.draw(); // 输出 "Drawing rectangle..."

        ShapeFactoryRef factoryRef = new ShapeFactoryRef();
        Shape circleRef  = factoryRef.getShape("example.patterns.factory.Circle");
        circleRef.draw(); // 输出 "Drawing circle..."

        Shape rectangleRef  = factoryRef.getShape("example.patterns.factory.Rectangle");
        rectangleRef.draw(); // 输出 "Drawing rectangle..."

        Shape rectangleRef2  = factoryRef.getShape("example.patterns.factory.Rectangle2");
        rectangleRef2.draw(); // 输出 "Drawing rectangle2..."
    }
}
