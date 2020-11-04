package algorithm.string.leetcode;

import java.util.*;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/11/1
 */

public class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {

        //1.求是否可以拆分
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        //2.如果可以拆分，dfs求结果
        List<String> ans = new ArrayList<>();
        if (dp[len]) {
            Deque<String> temp = new ArrayDeque<>();
            dfs(s, len, set, dp, temp, ans);
            return ans;
        }

        return ans;
    }

    //对于字符串s从后往前看
    //这样才能用上之前算的dp
    public void dfs(String s, int length, Set<String> set, boolean[] dp, Deque<String> temp, List<String> ans) {
        if (length == 0) {
            ans.add(String.join(" ", temp));
            return;
        }

        for (int i = length - 1; i >= 0; i--) {
            if (set.contains(s.substring(i, length)) && dp[i]) {
                temp.push(s.substring(i, length));
                dfs(s, i, set, dp, temp, ans);
                temp.pop();
            }
        }
    }
}
