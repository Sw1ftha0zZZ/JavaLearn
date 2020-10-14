package algorithm.dp.book;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/09
 */

public class GroupPack {
    Scanner sc = new Scanner(System.in);
    int maxV = 105;
    int maxN = 105;
    int N, M, V;
    int[] dp = new int[maxV];
    int[] v = new int[maxN];
    int[] w = new int[maxN];

    void run() {
        N = sc.nextInt(); V = sc.nextInt();
        for (int i = 0; i < N; i++) {
            M = sc.nextInt();
            for (int j = 0; j < M; j++) {
                v[j] = sc.nextInt();
                w[j] = sc.nextInt();
            }
            for (int j = V; j >= 0; j--) {
                for (int k = 0; k < M; k++) {
                    if (j >= v[k]) {
                        dp[j] = Math.max(dp[j], dp[j - v[k]] + w[k]);
                    }
                }
            }
        }
        System.out.println(dp[V]);
    }

    public static void main(String[] args) {
        GroupPack m = new GroupPack();
        m.run();
    }


}
