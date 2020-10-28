package algorithm.array.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/26
 */

public class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;

        //根据数据范围初始化
        int[] count = new int[101];

        //统计nums中每个元素出现的频次
        for (int i = 0; i < len; i++) {
            count[nums[i]]++;
        }
        //统计小于等于当前元素的数目
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }

        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }
        return res;
    }
}
