package algorithm.hash.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/28
 */

public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        for (int num : arr) {

            //使用getOrDefault方法省去判断
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //使用set统计次数的次数
        Set<Integer> set = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            //使用getValue方法
            set.add(entry.getValue());
        }

        return map.size() == set.size();
    }
}
