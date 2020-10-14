package juc.thread;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 *
 * 测试Thread类中的常用方法：
 *
 * 1. start(): (1)启动当前线程 + （2）调用当前线程的run()
 *
 * 2. run(): 通常需要重写Thread类中的此方法，将线程要执行的操作声明在run中
 *
 * 3. currentThread() : 静态方法，返回执行当前代码的线程
 *
 * 4. getName() :获取当前线程的名字
 *
 * 5. setName()
 *
 * 6. yield() : 释放当前cpu的执行权
 *
 * 7. join() : 在线程a中调用线程b的join方法，线程a就进入阻塞状态，直到线程b完全执行完，线程a才结束阻塞状态
 *             注意这里不是线程a直接恢复执行，要看线程a能不能拿到cpu
 *
 * 8. sleep(long millitime): 让当前线程睡眠指定的毫秒数。在指定的毫秒时间内，当前线程是阻塞状态
 *
 * 9. isAlive() : 判断当前线程是否存活
 */

class ThreadHello extends Thread {
    public ThreadHello(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            if (i % 2 == 1) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        ThreadHello t = new ThreadHello("1");
        //t.setName("线程一");
        t.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; ++i) {
            if (i % 2 == 0) {

                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

            if (i == 20){
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
