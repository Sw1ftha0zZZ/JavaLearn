package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/17
 */

public class Solution338 {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public static void main(String[] args) {
        //4 & 1 == 100 & 001 == 0
        //3 & 1 == 011 & 001 == 1
        //x & 1 == x % 2
        System.out.println(4 & 1);
    }
}
