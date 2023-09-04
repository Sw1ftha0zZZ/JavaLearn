package algorithm.sort.leetcode;
import	java.util.ArrayList;

import java.util.List;

/**
 * 放左边的元素的时候，要看右边已经放了多少，已经放了多少就是逆序对个数
 *
 * @author xinghao
 * @date 2020/08/03
 */

public class Solution315 {
    // 归并的过程中更新indexes 和result，数组是要从小到大排序
    public void merge(int[] nums, int start, int mid, int end, int[] indexes, int[] result){
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        //注意这个地方是从0开始的，而不是从start开始的
        for (int idx = 0; idx <= end - start; idx++){
            if (i > mid){
                // 数组从小到大排列，左指针都走到头了，开始放右指针，所以不用更新res数组
                temp[idx] = indexes[j];
                j++;
                continue;
            }
            if (j > end){
                temp[idx] = indexes[i];
                i++;
                // 右指针都已经到头了，这时才放左边的这个i指针，说明当前索引下的右边有 (end - mid) 个元素比当前元素小
                // 方法是递归的，所以要 +=
                result[temp[idx]] += (end - mid);
                continue;
            }
            //注意这里要用indexes数组定位，这里必须是<=，而且题目说的是比当前元素小，所以这里带等于
            if (nums[indexes[i]] <= nums[indexes[j]]){
                temp[idx] = indexes[i];
                i++;

                // 左指针代表的元素更小，要看右指针已经向右走了几步，走了几步就是右边已经安置好的元素个数
                // 也就是右边比当前i指向元素更小的
                result[temp[idx]] += (j - mid - 1);
            }else {
                // 右指针代表的元素更小，当前函数调用下看不出右边还有多少个比当前的更小的
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
        // 归并排序的优化，如果索引数组有序，则不存在逆序关系，没有必要合并
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

        //索引数组，真正拿来做排序的数组（因为本题不动nums数组），先初始化indexes
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            indexes[i] = i;
        }
        //保存结果的数组，即当前元素的右边比当前元素小的个数
        int[] result = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, indexes, result);


        for (int i = 0; i < nums.length; ++i) {
            list.add(result[i]);
        }
        return list;
    }
}
