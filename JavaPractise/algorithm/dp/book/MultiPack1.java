package algorithm.dp.book;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/09
 */

public class MultiPack1 {
    void run(){
        int n = jin.nextInt();
        int m = jin.nextInt();

        for (int i = 1 ; i <= n ; i++) {
            v[i] = jin.nextInt();
            w[i] = jin.nextInt();
            s[i] = jin.nextInt();
        }
        int res = dp(n, m);
        System.out.println(res);
    }

    int dp(int n, int m){
        int[] f = new int[maxN];
        for (int i = 1 ; i <= n ;i ++){
            for (int j = m ; j >= v[i] ; j--){
                for (int k = 0 ; k <= s[i] && k* v[i] <= j ;k++){
                    // 把最简单的完全背包改写下
                    f[j] = Math.max(f[j], f[j - k* v[i]] + k* w[i]);
                }
            }
        }
        return f[m];
    }

    int maxN = 1002;
    int[] v = new int[maxN];
    int[] w = new int[maxN];
    int[] s = new int[maxN];
    Scanner jin = new Scanner(System.in);
    public static void main(String[] args)  {new MultiPack1().run();}


}
