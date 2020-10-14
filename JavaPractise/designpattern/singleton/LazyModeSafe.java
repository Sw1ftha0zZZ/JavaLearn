package designpattern.singleton;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/15
 *
 * 懒汉的多线程安全实现方式
 */

public class LazyModeSafe {

    private LazyModeSafe() {}

    private static LazyModeSafe INSTANCE;

    public static synchronized LazyModeSafe getInstance() {
        if (INSTANCE == null){
            INSTANCE = new LazyModeSafe();
        }

        return INSTANCE;
    }
}
