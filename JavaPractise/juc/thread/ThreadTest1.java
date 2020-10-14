package juc.thread;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */

//1.创建一个实现了Runnable接口的类
class My implements Runnable {
    //2.重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 20; ++i) {
            if (i % 2 == 0) {

                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        //3.创建实现类对象
        My my = new My();
        //4.将对象作为参数传到Thread的构造器中
        //5.调用start方法
        new Thread(my, "线程一").start();
        new Thread(my, "线程二").start();
    }
}
