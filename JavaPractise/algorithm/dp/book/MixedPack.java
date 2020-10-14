package algorithm.dp.book;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/09
 */

public class MixedPack {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 物品个数
        int N = sc.nextInt();
        // 背包总容量
        int V = sc.nextInt();
        int[] dp = new int[V + 1];
        for(int i = 0; i < N; i++){
            int v = sc.nextInt(); // 体积
            int w = sc.nextInt(); // 价值
            int s = sc.nextInt(); // 数量
            if(s == 0){
                // 完全背包问题
                for(int j = v; j <= V; j++){
                    dp[j] = Math.max(dp[j], dp[j - v] + w);
                }
            }else{
                // 多重背包问题，01背包是多重背包的特例，可以一并处理
                s = Math.abs(s);
                for(int j = 1; s >= j; s -= j, j *= 2){
                    for(int k = V; k >= j * v; k--){
                        dp[k] = Math.max(dp[k], dp[k - j * v] + j * w);
                    }
                }
                if(s > 0){
                    for(int j = V; j >= s * v; j--){
                        dp[j] = Math.max(dp[j], dp[j - s * v] + s * w);
                    }
                }
            }
        }
        System.out.println(dp[V]);
    }


}
