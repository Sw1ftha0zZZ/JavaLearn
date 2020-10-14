package designpattern.singleton;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/15
 *
 * 基于 classloader 机制避免了多线程的同步问题
 *
 * 但是没有做到lazy load
 */

public class HungryMode {
    private HungryMode() {}

    private static HungryMode INSTANCE = new HungryMode();

    public static HungryMode getInstance() {
        return INSTANCE;
    }
}
