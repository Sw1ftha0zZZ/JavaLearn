package juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/26
 */

public class LockConditionTest {
    int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increasement() {
        lock.lock();

        try{
            while (num != 0) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + num);
            condition.signalAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decreasement() {
        lock.lock();

        try{
            while (num == 0) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+ num);
            condition.signalAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockConditionTest l = new LockConditionTest();
        new Thread(() -> {
            for (int i = 0; i < 10; i++){
                l.increasement();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++){
                l.decreasement();
            }
        }, "B").start();
    }
}
