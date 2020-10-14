package algorithm.dp.book;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/09
 */

/*

拆成01背包来做，按二进制去拆
即 v,w,s = v,w,7 时：
正常拆分：-> (v,w)，(v,w)，(v,w)，(v,w)，(v,w)，(v,w)，(v,w)
二进制拆分：-> (v,w),(v<<1,w<<1),(v<<2,w<<2)

*/


public class MultiPackBinaryPartition {

    void run(){
        int n = jin.nextInt();
        int m = jin.nextInt();

        int p = 1;
        for (int i = 1; i <= n ; i++){
            int V = jin.nextInt();
            int W = jin.nextInt();
            int S = jin.nextInt();
            int k = 1;
            while (S > k){
                v[p] = V*k;
                w[p] = W*k;
                S -= k;
                k *= 2;
                p++;
            }

            //10拆分成1 + 2 + 4 + 3
            if (S > 0){
                v[p] = V*S;
                w[p] = W*S;
                p ++;
            }
        }

        //这里的参数是p, m
        //而不是n, m
        int res = dp(p, m);
        System.out.println(res);

    }


    int dp(int n, int m){

        int[] f = new int[maxN];
        for (int i= 1; i <= n ; i ++){
            for (int j = m ; j>= v[i] ; j--){
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        return f[m];

    }
    int maxN = 200002;
    int[] v = new int[maxN];
    int[] w = new int[maxN];

    Scanner jin = new Scanner (System.in);
    public static void main(String[] args) {new MultiPackBinaryPartition().run();}



}
