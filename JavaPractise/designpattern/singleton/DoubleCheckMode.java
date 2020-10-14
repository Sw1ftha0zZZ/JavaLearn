package designpattern.singleton;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/15
 */

public class DoubleCheckMode {

    private static volatile DoubleCheckMode instance;
    private DoubleCheckMode (){
    }
    public static DoubleCheckMode getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckMode.class) {
                if (instance == null) {
                    instance = new DoubleCheckMode();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        DoubleCheckMode d1 = getInstance();
        DoubleCheckMode d2 = getInstance();
        System.out.println(d1.hashCode());
        System.out.println(d2.hashCode());
    }
}
