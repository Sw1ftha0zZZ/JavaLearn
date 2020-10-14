package algorithm.binarySearch;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/13
 *
 * 对mid的求法是要根据if判断逻辑来决定的
 * 如果if判断逻辑后会出现left = mid,那么就要+1
 * 否则，不加1
 */

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0){
            return new int[] {-1, -1};
        }
        int firstIndex = findFirstPosition(nums, target);
        if (firstIndex == -1){
            return new int[] {-1, -1};
        }
        int lastIndex = findLastPosition(nums, target);
        return new int[] {firstIndex, lastIndex};
    }
    public int findLastPosition(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left + 1) / 2;
            //如果中值比target大，说明在右边是不会找到最后一次出现的位置的，要去左边找
            if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return left;
    }
    public int findFirstPosition(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //如果中值比target小，说明在左边不会找到元素第一次出现的位置，要去右边找
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        //因为target可能不存在，所以要判断此时的left处的值是否等于target
        if (nums[left] == target){
            return left;
        }
        return -1;
    }
}
