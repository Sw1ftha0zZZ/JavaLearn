package algorithm.binarySearch;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/19
 */

public class Solution154 {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else if (nums[mid] < nums[right]){
                right = mid;
            }else {
                right--;
            }
        }
        return nums[left];
    }
}
