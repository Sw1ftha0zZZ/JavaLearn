package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/08
 */

public class Solution152 {

    //优化空间复杂度
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int maxDp = nums[0];
        int minDp = nums[0];
        int ans = nums[0];


        for (int i = 1; i < len; i++) {

            //保存上一次的结果
            int preMax = maxDp;
            int preMin = minDp;
            maxDp = Math.max(preMax * nums[i], Math.max(nums[i], preMin * nums[i]));
            minDp = Math.min(preMin * nums[i], Math.min(nums[i], preMax * nums[i]));

            ans = Math.max(ans, maxDp);
        }

        return ans;
    }

    public int maxProduct1(int[] nums) {
        int len = nums.length;
        int[] maxDp = new int[len];
        int[] minDp = new int[len];

        //初始化两个数组
        System.arraycopy(nums, 0, maxDp, 0, len);
        System.arraycopy(nums, 0, minDp, 0, len);

        for (int i = 1; i < len; i++) {
            //因为会有负数，所以要保存两个数组
            maxDp[i] = Math.max(maxDp[i - 1] * nums[i], Math.max(nums[i], minDp[i - 1] * nums[i]));
            minDp[i] = Math.min(minDp[i - 1] * nums[i], Math.min(nums[i], maxDp[i - 1] * nums[i]));

        }
        int ans = maxDp[0];
        for (int m: maxDp) {
            ans = Math.max(ans, m);
        }

        return ans;
    }
}
