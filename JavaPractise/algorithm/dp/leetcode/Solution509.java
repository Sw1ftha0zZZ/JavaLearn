package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/06
 */

public class Solution509 {
    public int fib(int N) {
        if (N == 0){
            return 0;
        }
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    public int fib1(int N) {
        if (N <= 1){
            return N;
        }
        int pre = 0;
        int next = 1;
        int res = 0;
        for (int i = 2; i <= N; i++) {
            res = pre + next;
            pre = next;
            next = res;
        }
        return next;
    }
}
