package example.patterns.factory;

/**
 * @author com.luo.prodemo.luo
 * @date 2022/12/8 11:19
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing rectangle...");
    }
}