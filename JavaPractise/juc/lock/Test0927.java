package juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */

public class Test0927 {
    private int flag = 1;
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

            System.out.println(Thread.currentThread().getName() + "hello");

            flag = 2;
            condition2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void method2() {
        lock.lock();
        try{
            while (flag != 2) {
                condition2.await();
            }

            System.out.println(Thread.currentThread().getName() + "hello");

            flag = 3;
            condition3.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void method3() {
        lock.lock();
        try{
            while (flag != 3) {
                condition3.await();
            }

            System.out.println(Thread.currentThread().getName() + "hello");

            flag = 1;
            condition1.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Test0927 t = new Test0927();
        new Thread(() -> {
            for (int i = 0; i< 5; i++) {
                t.method1();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i< 5; i++) {
                t.method2();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i< 5; i++) {
                t.method3();
            }
        }).start();
    }
}
