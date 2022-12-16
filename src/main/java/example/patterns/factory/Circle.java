package example.patterns.factory;

/**
 * @author com.luo.prodemo.luo
 * @date 2022/12/8 11:18
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing circle...");
    }
}