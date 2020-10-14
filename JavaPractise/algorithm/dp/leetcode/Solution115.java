package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/20
 */

public class Solution115 {
    public int numDistinct(String s, String t) {
        char[] csS = (" " + s).toCharArray();
        char[] csT = (" " + t).toCharArray();
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        //空集一定是子集
        for(int i = 0; i <= s.length(); i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(csS[i] == csT[j]){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
