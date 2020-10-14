package algorithm.sort.leetcode;
import	java.util.ArrayList;

import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/03
 */

public class Solution315 {
    public void merge(int[] nums, int start, int mid, int end, int[] indexes, int[] result){
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        //注意这个地方是从0开始的，而不是从start开始的
        for (int idx = 0; idx <= end - start; idx++){
            if (i > mid){
                temp[idx] = indexes[j];
                j++;
                continue;
            }
            if (j > end){
                temp[idx] = indexes[i];
                i++;
                result[temp[idx]] += (end - mid);
                continue;
            }
            //注意这里要用indexes数组定位，这里必须是<=
            if (nums[indexes[i]] <= nums[indexes[j]]){
                temp[idx] = indexes[i];
                i++;
                result[temp[idx]] += (j - mid - 1);
            }else {
                temp[idx] = indexes[j];
                j++;
            }
        }
        for (int idx = 0; idx <= end - start; idx++){
            indexes[start + idx] = temp[idx];
        }
    }


    public void mergeSort(int[] nums, int start, int end, int[] indexes, int[] result){
        if (start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid, indexes, result);
        mergeSort(nums, mid + 1, end, indexes, result);

        //注意这里是nums[indexes[mid]] <= nums[indexes[mid + 1]]
        //不要写成nums[mid] <= nums[mid + 1]，这个时候索引数组已经根据原数组排序做了顺序变换的
        if (nums[indexes[mid]] <= nums[indexes[mid + 1]]){
            return;
        }
        merge(nums, start, mid, end, indexes, result);
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<Integer> ();
        if (nums.length == 0){
            return list;
        }

        //索引数组，真正拿来做排序的数组
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            indexes[i] = i;
        }
        //保存结果的数组
        int[] result = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, indexes, result);


        for (int i = 0; i < nums.length; ++i) {
            list.add(result[i]);
        }
        return list;
    }
}
