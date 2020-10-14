package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/01
 */

public class Solution72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        //这里多初始化一个，相当于s1和s2的前面都加一个空位
        int[][] dp = new int[m + 1][n + 1];

        //dp[i][j]表示word1从0到i的子串变成word2从0到j的子串所需的最少操作数
        //word1变成word2和word2变成word1所需的操作数是一样的（可逆的）

        //base case
        //word1变成长度为0的word2需要做i次删除操作
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        //长度为0的word1变成长度为i的word2需要i次插入操作
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //如果相等那就都往前移动一位
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    //不相等就在插入dp[i][j - 1]，替换dp[i - 1][j - 1]，删除dp[i - 1][j]中选一个最小的操作

                    //1.插入dp[i][j - 1]
                    //直接在 s1[i] 插入一个和 s2[j] 一样的字符,那么 s2[j] 就被匹配了，前移 j，继续跟 i 对比

                    //2.替换dp[i - 1][j - 1]
                    //直接把 s1[i] 替换成 s2[j]，这样它俩就匹配了,同时前移 i，j 继续对比

                    //3.删除dp[i - 1][j]
                    //直接把 s[i] 这个字符删掉，前移 i，继续跟 j 对比

                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "fk";
        System.out.println(s.length());
        System.out.println("fk".charAt(1));
    }
}
