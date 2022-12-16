package example.patterns.factory;

/**
 * @author com.luo.prodemo.luo
 * @date 2022/12/8 11:29
 */
public class ShapeFactoryRef {
    public Shape getShape(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            return (Shape) clazz.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
