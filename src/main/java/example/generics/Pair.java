package example.generics;

/**
 * @author luo
 * @date 2022/12/16 18:11
 */
public class Pair<T, U> {
    /**
     * 请注意，如果对象是可变的，那么将变量设置为final并不会阻止它所引用的对象被修改。
     * 它只会防止变量被重新分配以引用其他对象。
     */
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("hello", 42);
        pair.setFirst("sd");
        String first = pair.getFirst();
        int second = pair.getSecond();
        System.out.println("first:" + first + " and second: " + second);
        //int first = pair.getFirst();   Compiler error: cannot convert from String to int
    }
}
