package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/20
 */

public class Solution91 {
    public int numDecodings(String s) {
        if (s == null) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        if (charArray[0] == '0') {
            return 0;
        }
        int len = charArray.length;

        //dp[i]表示以charArray[i]为结尾的前缀子串有多少种解码方法
        int[] dp = new int[len + 1];
        dp[0] = 1;

        // dp[i] = dp[i - 1] * 1 if s[i] != '0'
        // dp[i] += dp[i - 2] * 1 if  10 <= int(s[i - 1..i]) <= 26



        for (int i = 1; i < len; i++) {
            if (charArray[i] != '0') {
                dp[i] += dp[i - 1];
            }

            int num = (charArray[i - 1] - '0') * 10 + (charArray[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                }else {
                    dp[i] += dp[i - 2];
                }

            }

        }
        return dp[len - 1];
    }
}
