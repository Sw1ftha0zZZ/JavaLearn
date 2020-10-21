package algorithm.array.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/14
 */

public class Solution1002 {
    public List<String> commonChars(String[] A) {

        //使用 minfreq[c] 存储字符 c 在所有字符串中出现次数的最小值。
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);

        for (String word : A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                freq[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minfreq[i]; j++) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }

        return ans;
    }
}
