package algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/04
 */

public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //先将数组排序
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, temp, result);
        return result;
    }
    public void dfs(int[] nums, int pos, List<Integer> temp, List<List<Integer>> result){
        result.add(new ArrayList<>(temp));

        for (int i = pos; i < nums.length; i++){

            //比78多出来的部分
            if (i > pos && nums[i - 1] == nums[i]){
                continue;
            }

            temp.add(nums[i]);
            dfs(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);

        }
    }
}
