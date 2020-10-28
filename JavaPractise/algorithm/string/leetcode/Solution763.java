package algorithm.string.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/22
 *
 * 贪心 + 双指针
 */

public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int len = S.length();
        //先遍历一遍s，找到每个字母出现的最后索引
        for (int i = 0; i < len; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);

            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
