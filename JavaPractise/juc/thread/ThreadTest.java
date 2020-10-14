package juc.thread;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */

class Test1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; ++i) {
            if (i % 2 == 0) {

                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

}

class Test2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; ++i) {
            if (i % 2 == 1) {

                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

}

public class ThreadTest {
    public static void main(String[] args) {

//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 500; i++) {
//                    if (i % 2 == 0) {
//                        System.out.println(Thread.currentThread().getName() + ": " + i);
//                    }
//                }
//            }
//        }.start();
//
//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 500; i++) {
//                    if (i % 2 == 1) {
//                        System.out.println(Thread.currentThread().getName() + ": " + i);
//                    }
//                }
//            }
//        }.start();








        Test1 test1 = new Test1();
        test1.setName("test1");
        Test2 test2 = new Test2();
        test2.setName("test2");
        test1.start();
        test2.start();

        //1. 同一个实例不能通过调用两次start来启动两个线程
        //test.start();


        //2. 实例调用run方法不能启动多线程
//        test.run();
//        test1.run();



    }

}
