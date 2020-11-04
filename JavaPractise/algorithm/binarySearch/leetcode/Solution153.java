package algorithm.binarySearch.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/19
 */

public class Solution153 {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;

            //这样说明mid一定不是最小
            //同时，因为这个是旋转数组，这种情况下的左半部分一定不包含最小值
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else {

                //由于题目假设不存在重复元素，所以这里else指的一定是nums[mid] < nums[right]
                right = mid;
            }

        }
        return nums[left];
    }
}
