package designpattern.singleton;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/15
 *
 * 懒汉模式
 */

public class LazyMode {
    /**
     * 私有化构造方法
     */
    private LazyMode() {}

    /**
     * 静态私有的实例
     * static保证类没有创建实例也可以用这个实例
     */
    private static LazyMode INSTANCE = null;

    /**
     * public的访问单例的方法
     * 这个方法也必须是static的，不然无法返回static的INSTANCE
     *
     * 注意，这个方法是线程不安全的
     */
    public static LazyMode getInstance() {

        if (INSTANCE == null){
            INSTANCE = new LazyMode();
        }

        return INSTANCE;
    }

}
