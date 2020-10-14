package algorithm.dfs;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/28
 *
 * 这个dfs是有返回值的，其他的题是没有返回值的
 *
 * 有返回值是因为这个题只要发现一个解就返回true了，不需要找到所有的解
 *
 * 如果需要找到所有的解，那就不用返回值，但是需要一个res来保存每个ok的解
 */

public class Solution698 {
    public boolean dfs(int[] nums, int k, int target, int currSum, int startIndex, boolean[] visited) {
        //终止条件
        if (k == 0) {
            return true;
        }

        if (currSum == target) {
            //构建下一个集合
            return dfs(nums, k - 1, target, 0, 0, visited);
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i] && currSum + nums[i] <= target) {
                visited[i] = true;

                if (dfs(nums, k, target, currSum + nums[i], i + 1, visited)) {
                    return true;
                }

                visited[i] = false;
            }
        }

        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (maxNum < nums[i]) {
                maxNum = nums[i];
            }
        }

        if (sum % k != 0 || maxNum > sum / k){
            return false;
        }

        boolean[] visited = new boolean[nums.length];

        return dfs(nums, k, sum / k, 0, 0, visited);
    }
}
