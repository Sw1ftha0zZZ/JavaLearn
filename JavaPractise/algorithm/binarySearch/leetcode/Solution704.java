package algorithm.binarySearch.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/12
 *
 * 注意：二分查找不是递归
 * 而是在循环中不断修改左右指针来达到二分查找的目的
 */

public class Solution704 {
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
