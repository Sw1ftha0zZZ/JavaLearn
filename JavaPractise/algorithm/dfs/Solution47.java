package algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */

public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        //这个题需要去重，所以需要visited数组保存是否访问过
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, visited, temp, result);
        return result;
    }
    public void dfs(int[] nums, int pos, int[] visited, List<Integer> temp, List<List<Integer>> result){

        if (temp.size() == nums.length){

            result.add(new ArrayList<>(temp));
            return;

        }

        for (int i = 0; i < nums.length; i++){

            //如果当前元素没被访问过
            //而且要么i是第一个元素，要么i和i-1对应的值不一样，要么i-1没被访问过
            //做如下操作
            if (visited[i] == 0 && (i == 0 || nums[i] != nums[i - 1] || visited[i - 1] == 0)){
                temp.add(nums[i]);
                visited[i] = 1;


                dfs(nums, i + 1, visited, temp, result);


                temp.remove(temp.size() - 1);
                visited[i] = 0;
            }

        }
    }
}
