package javaabc.scanner;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/11/3
 *
 * 用于针对牛客网的输入输出
 */

public class TestScanner {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        //读取二维数组
//        int h = sc.nextInt();
//        int w = sc.nextInt();
//        int[][] arr = new int[h][w];
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }


        //读取一行整数
        Scanner sc1 = new Scanner(System.in);
        String s = sc1.nextLine();
        String[] strings = s.split(" ");
        int[] a = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            a[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(Arrays.toString(a));

//        //读取多行
//        while (sc1.hasNextLine()) {
//
//        }

//        //读取多个整数
//        while (sc1.hasNextInt()) {
//
//        }

    }
}
