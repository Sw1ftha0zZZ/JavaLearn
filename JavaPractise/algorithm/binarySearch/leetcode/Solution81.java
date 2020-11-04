package algorithm.binarySearch.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/18
 *
 * 在33的基础上，数组中元素可能会重复
 */

public class Solution81 {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0){
            return false;
        }
        int left = 0;
        int right = len - 1;
        int mid;
        while (left <= right){
            mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return true;
            }

            //这三行是比33多出来的判断
            if (nums[left] == nums[mid]){
                left++;
                continue;
            }


            //左半部分有序
            if (nums[mid] > nums[left]){
                if (nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
