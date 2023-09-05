package algorithm.binarySearch.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/17
 *
 * 注意：二分查找不是递归
 * 旋转数组，不管mid取在哪里，一定有一半是有序的
 * 可以通过比较端点处的值来看哪半部分是有序的
 */

public class Solution33 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0){
            return -1;
        }
        int left = 0;
        int right = len - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }

            //判断是mid左边有序还是mid右边有序
            // nums[left] <= nums[mid] 代表左半部分有序
            // nums[left] = nums[mid] 代表左半部分有序
            // nums[right] = nums[mid] 右半部分不一定有序
            //左半部分有序:nums[left] <= nums[mid]，注意，这里有等于号
            if (nums[left] <= nums[mid]){
                // 左边有序
                // 看target在左边还是在右边
                if (nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                // 右边有序
                // 看target在左边还是在右边
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }
}
