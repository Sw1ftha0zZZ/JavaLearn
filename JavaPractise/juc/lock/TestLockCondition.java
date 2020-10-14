package juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/26
 *
 * 精准通知
 *
 * 标志位 + 同一个lock的多个condition
 */

public class TestLockCondition {
    //flag = {1, 2, 3}
    private int flag = 1;
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void method1() {
        lock.lock();
        try{
            while (flag != 1) {
                condition1.await();
            }

            for (int i = 0; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            flag = 2;
            condition2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void method2() {
        lock.lock();
        try{
            while (flag != 2) {
                condition2.await();
            }

            for (int i = 0; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            flag = 3;
            condition3.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void method3() {
        lock.lock();
        try{
            while (flag != 3) {
                condition3.await();
            }

            for (int i = 0; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            flag = 1;
            condition1.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public static void main(String[] args) {
        TestLockCondition t = new TestLockCondition();

        new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                t.method1();
            }
        }, "Thread 1").start();
        new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                t.method2();
            }
        }, "Thread 2").start();
        new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                t.method3();
            }
        }, "Thread 3").start();
    }

}
