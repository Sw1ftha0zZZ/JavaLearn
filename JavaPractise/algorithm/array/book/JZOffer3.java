package algorithm.array.book;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/21
 */

public class JZOffer3 {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int findRepeatNumber(int[] nums) {

        //也是哈希的思想，但是不需要哈希表存储，只要o（1）的空间复杂度
        //但是会改变原来的数组
        for (int i = 0; i < nums.length; i++) {
            //把nums[i]换到下标为nums[i]的位置，注意这里是while
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }
}
