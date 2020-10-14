package juc.thread;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */

class Te11 implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 210; ++i) {
            if (i % 2 == 1) {

                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}


public class ThreadTest2 {
    public static void main(String[] args) {



        new Thread(() -> {
            for (int i = 0; i < 210; ++i) {
                if (i % 2 == 1) {

                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }, "线程一").start();
        new Thread(() -> {
            for (int i = 0; i < 210; ++i) {
                if (i % 2 == 0) {

                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }, "线程二").start();

        new Thread(() -> {
            System.out.println("Hello");
        }).start();


    }

}
