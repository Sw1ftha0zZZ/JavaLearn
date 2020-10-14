package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/04
 */

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        //这个题需要去重，所以需要visited数组保存是否访问过
        int[] visited = new int[nums.length];
        dfs(nums, visited, temp, result);
        return result;
    }
    public void dfs(int[] nums, int[] visited, List<Integer> temp, List<List<Integer>> result){

        if (temp.size() == nums.length){

            result.add(new ArrayList<>(temp));
            return;

        }

        for (int i = 0; i < nums.length; i++){

            //如果i已经访问过，就直接跳过当前循环
            if (visited[i] == 1){
                continue;
            }

            temp.add(nums[i]);
            visited[i] = 1;


            dfs(nums, visited, temp, result);


            temp.remove(temp.size() - 1);
            visited[i] = 0;
        }
    }
}
