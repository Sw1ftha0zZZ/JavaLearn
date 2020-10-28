package algorithm.array.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/21
 *
 * 和剑指Offer3一样的思路
 */

public class Solution41 {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {

            //在范围内而且没有放到正确的位置上，就做交换
            while (nums[i] > 0 && nums[i] <= len && i + 1 != nums[i]) {

                if (nums[nums[i] - 1] == nums[i]) {
                    break;
                }

                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        //都对的话，就返回len + 1
        return len + 1;
    }



    //将数组作为参数传入函数，对数组修改会改到外面
    //对基本类型和String做修改，外面都不会看见
    //对引用类型做修改，外面会看见
    public static void main(String[] args) {
        Solution41 s = new Solution41();
        int[] nums = {3,4,-1,1};
        int a = s.firstMissingPositive(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
