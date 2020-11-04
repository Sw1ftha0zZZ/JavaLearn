package algorithm.string.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/11/1
 */

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //去重
        Set<String> set = new HashSet<>(wordDict);

        int len = s.length();
        //dp[i] 表示字符串下标从0到i-1的子串是否可以拆分成字典中的词
        //一般和字符串相关的dp都要多初始化一个，dp[0]表示空串的情况
        boolean[] dp = new boolean[len + 1];
        //空串
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                //这个substring方法是不包含位置i的
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
