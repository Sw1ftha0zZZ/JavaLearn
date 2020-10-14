package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/28
 *
 * 01背包
 */

public class Solution416 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return false;
        }

        int target = 0;
        for (int num : nums) {
            target += num;
        }

        if (target % 2 == 1) {
            return false;
        }

        target /= 2;

        //dp[i]表示，nums数组中是否存在子集，恰好将背包容量为i的背包填满
        boolean[] dp = new boolean[target + 1];

        //背包容量为0一定可以填满
        dp[0] = true;

        // for (int i = 0; i < len; i++) {
        //     for (int j = target; j >= 0; j--) {
        //         if (j >= nums[i]) {
        //             dp[j] = dp[j] || dp[j - nums[i]];
        //         }
        //     }
        // }
        //Arrays.sort(nums);不需要排序就可以



        //下面这个写法是直接套01背包的公式，省去了一些不必要的判断
        for (int i = 0; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];
    }
}
