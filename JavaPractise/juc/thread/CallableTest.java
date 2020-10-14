package juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */

class CallTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0){
                sum += i;
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }

        return sum;
    }
}

class CallTest1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 1){
                sum += i;
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }

        return sum;
    }
}

public class CallableTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);
        es.submit(new CallTest1());
        es.submit(new CallTest());

        ExecutorService es1 = Executors.newFixedThreadPool(4);
        es1.submit(new CallTest1());
        es1.submit(new CallTest());


        es.shutdown();
        es1.shutdown();
    }
}
