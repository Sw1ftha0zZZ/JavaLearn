package algorithm.string.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/06
 */

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> visited = new HashSet<>();
        int len = s.length();
        //右指针，初始为-1，相当于还在字符串左侧，还没有移动
        int rightPointer = -1;
        int ans = 0;

        for (int i = 0; i < len; i++) {

            //移除上次（i-1）时的字符，因为左指针已经往右边指了
            if (i > 0) {
                visited.remove(s.charAt(i - 1));
            }

            while (rightPointer + 1 < len && !visited.contains(s.charAt(rightPointer + 1))) {

                visited.add(s.charAt(rightPointer + 1));

                rightPointer++;
            }

            ans = Math.max(ans, rightPointer - i + 1);
        }
        return ans;
    }
}
