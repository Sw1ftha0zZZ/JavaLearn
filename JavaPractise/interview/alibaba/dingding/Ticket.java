package interview.alibaba.dingding;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/*
 * 某场演唱会门票1000张（票面编号0-999），落入了黄牛A、B、C手中，
 * 三人同时对外售票（按编号顺序并行卖票），票价500/张，总票数每卖掉100张，每张票涨价100元。
 * 最终打印出三个人卖掉每张票的编号和每人的总收入。
 */
public class Ticket {

    private static int num = 0;
    private static final String LOCK = "LOCK";

    private static List<Integer> listA = new CopyOnWriteArrayList<>();
    private static List<Integer> listB = new CopyOnWriteArrayList<>();
    private static List<Integer> listC = new CopyOnWriteArrayList<>();

    private static int numA = 0;
    private static int numB = 0;
    private static int numC = 0;

    public static void main(String[] args) {

        Thread tA = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (LOCK) {
                        if (num >= 1000) {
                            break;
                        }
                        listA.add(num);
                        //System.out.println("listA: " + (num));
                        int price = num / 100 * 100 + 500;
                        numA += price;
                        num++;
                    }
                }
            }
        });

        Thread tB = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (LOCK) {
                        if (num >= 1000) {
                            break;
                        }
                        listB.add(num);
                        //System.out.println("listB: " + (num));
                        int price = num / 100 * 100 + 500;
                        numB += price;
                        num++;
                    }
                }
            }
        });

        Thread tC = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (LOCK) {
                        if (num >= 1000) {
                            break;
                        }
                        listC.add(num);
                        //System.out.println("listC: " + (num));
                        int price = num / 100 * 100 + 500;
                        numC += price;
                        num++;
                    }
                }
            }
        });

        tA.start();
        tB.start();
        tC.start();

        while (listA.size() + listB.size() + listC.size() < 1000) {
            continue;
        }
        System.out.println("listA: " + listA);
        System.out.println("listB: " + listB);
        System.out.println("listC: " + listC);

        //System.out.println(verify());

        System.out.println("numA: " + numA);
        System.out.println("numB: " + numB);
        System.out.println("numC: " + numC);
        //System.out.println(numA + numB + numC);

    }

    static boolean verify() {
        int ab = listA.stream().filter(elem -> listB.contains(elem)).collect(Collectors.toList()).size();
        int ac = listA.stream().filter(elem -> listC.contains(elem)).collect(Collectors.toList()).size();
        int bc = listC.stream().filter(elem -> listB.contains(elem)).collect(Collectors.toList()).size();
        return ab == 0 && ac == 0 && bc == 0;
    }
}