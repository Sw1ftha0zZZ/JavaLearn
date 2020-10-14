package algorithm.dfs;
import	java.util.ArrayList;

import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/27
 */

public class Solution78 {



    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<> ();
        List<Integer> track = new ArrayList<> ();
        dfs(nums, 0, track, result);
        return result;
    }
    public void dfs(int[] nums, int pos, List<Integer> track, List<List<Integer>> result){

        result.add(new ArrayList<>(track));
        for (int i = pos; i < nums.length; ++i) {
            track.add(nums[i]);
            //这里是对i + 1的位置做dfs，而不是pos + 1
            dfs(nums, i + 1, track, result);
            track.remove(track.size() - 1);
        }

    }
}
