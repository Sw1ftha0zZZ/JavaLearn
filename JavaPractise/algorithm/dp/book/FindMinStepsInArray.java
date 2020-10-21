package algorithm.dp.book;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/16
 *
 * 给定一个正整数数组，最大为100个成员，从第一个成员开始，走到数组最后一个成员最少的步骤数，
 * 第一步必须从第一元素开始，1<=步长<len/2,
 * 第二步开始以所在成员的数字走相应的步数，如果目标不可达返回-1，只输出最少的步骤数量
 *
 * input: [1, 5, 1, 9, 4, 2, 6, 8, 3, 5, 4, 3, 9]
 * output: 2
 */

public class FindMinStepsInArray {
    public int minSteps(int[] nums) {
        int len = nums.length;

        //这个题必须要从后往前算，dp[i]表示到dp[len - 1]的步骤数
        int[] dp = new int[len];
        dp[len - 1] = 0;

        //从后往前看，看每个点是否能到最后
        for (int i = len - 2; i >= 0; i--) {
            //先赋值为最大值，表示不可达最后一个位置
            dp[i] = Integer.MAX_VALUE;

            if (i + nums[i] < len && dp[i + nums[i]] != Integer.MAX_VALUE) {
                dp[i] = dp[i + nums[i]] + 1;
            }

        }
        int ans = dp[0];
        //从第一个位置出发，第一步的步长是[0, len / 2)
        for (int i = 1; i < len / 2; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                ans = Math.min(ans, dp[i] + 1);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        FindMinStepsInArray f = new FindMinStepsInArray();
        int[] nums = {1, 5, 1, 9, 4, 2, 6, 8, 3, 5, 4, 3, 9};
        System.out.println(f.minSteps(nums));
    }
}
