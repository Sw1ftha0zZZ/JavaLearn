package algorithm.binarySearch.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/21
 *
 * 这个题是对数值做二分，而不是用数组索引做二分
 */

public class Solution287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;

        int left = 1;
        int right = n;

        while (left < right) {
            int mid = (left + right + 1) >> 1;

            int count = 0;

            //统计数组中严格小于mid的个数
            for (int num: nums) {
                if (num < mid) {
                    count++;
                }
            }

            //在1-n中，如果1-mid（左闭右开）的数量要大于等于mid，那说明一定在左半部
            //不然就在右半部
            if (count >= mid) {
                right = mid - 1;
            }else {
                left = mid;
            }

        }

        //这个题是对数值做二分，而不是对索引做二分，因为题目说明了数值是1到n
        return left;
    }
}
