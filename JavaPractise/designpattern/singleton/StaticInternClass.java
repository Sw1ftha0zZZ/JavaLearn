package designpattern.singleton;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/15
 *
 * 静态内部类实现单例模式
 *
 * 使用静态内部类持有单例对象
 *
 * 第一次加载SingletonIntern类时并不会初始化INSTANCE
 *
 * 只有在第一次调用getInstance方法时虚拟机加载LazyHandler并初始化INSTANCE
 *
 * 这样不仅利用类加载机制保证了线程安全，还可以实现Lazy Load
 */

public class StaticInternClass {

    private StaticInternClass() {}

    private static class LazyHandler {

        private static final StaticInternClass INSTANCE = new StaticInternClass();

    }

    public static StaticInternClass getInstance() {

        return LazyHandler.INSTANCE;

    }
}
