package algorithm.binarySearch;

import java.util.Arrays;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/20
 *
 * 贪心+二分
 *
 * 为了让上升子序列最长，就要让子序列上升的慢一点
 * 希望每次在上升子序列最后加上的那个数尽可能的小。
 */

public class Solution300 {
    public int lengthOfLIS(int[] nums){
        int len = nums.length;
        if (len <= 1){
            return len;
        }

        //tail数组用于保存原数组中的上升子序列
        int[] tail = new int[len];
        //init
        tail[0] = nums[0];
        //end是tail数组最后一个已被赋值的元素的index
        int end = 0;

        for (int i = 1; i < len; ++i) {
            //如果遍历到的nums[i]比tail[end]大，就end++，并将tail最后一个元素赋值
            if (nums[i] > tail[end]){
                end++;
                tail[end] = nums[i];
            }else {
                //二分法找nums[i]应该放在**tail数组**中的哪个位置
                int left = 0;
                int right = end;
                while (left < right) {
                    int mid = left + (right - left) / 2;

                    //要找的是放在tail数组中的哪里，nums[i]相当于target
                    //判断条件是tail[mid] < target
                    if (tail[mid] < nums[i]){
                        left = mid + 1;
                    }else {
                        right = mid;
                    }
                }
                // 走到这里是因为 【逻辑 1】 的反面，因此一定能找到第 1 个大于等于 nums[i] 的元素
                // 因此，无需再单独判断
                tail[left] = nums[i];
            }

            // 调试方法
            //printArray(nums[i], tail);

        }

        //返回长度，所以+1
        return end + 1;
    }

    /**
     dp解法
     dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
     */
    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int value : dp) {
            res = Math.max(res, value);
        }
        return res;
    }



    // 调试方法，以观察是否运行正确
    private void printArray(int num, int[] tail) {
        System.out.print("当前数字：" + num);
        System.out.print("\t当前 tail 数组：");
        int len = tail.length;
        for (int i = 0; i < len; i++) {
            if (tail[i] == 0) {
                break;
            }
            System.out.print(tail[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18, 4};
        Solution300 solution = new Solution300();

        int lengthOfLIS = solution.lengthOfLIS(nums);
        System.out.println("最长上升子序列的长度：" + lengthOfLIS);
    }
}
