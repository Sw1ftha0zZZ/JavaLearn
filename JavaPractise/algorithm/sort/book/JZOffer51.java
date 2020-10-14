package algorithm.sort.book;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/03
 *
 * 数组中的逆序对
 *
 * 利用归并排序计算数组中的逆序对，是非常经典的做法
 * 所有的「逆序对」来源于 3 个部分：
 *
 * 左边区间的逆序对；
 * 右边区间的逆序对；
 * 横跨两个区间的逆序对。
 */

public class JZOffer51 {
    public int merge(int[] nums, int start, int mid, int end){
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int res = 0;
        for (int idx = 0; idx <= end - start; idx++){
            if (j > end){
                temp[idx] = nums[i];
                i++;
                res += end - mid;
                continue;
            }
            if (i > mid){
                temp[idx] = nums[j];
                j++;
                continue;
            }

            //这个地方要是<=才对，不能写< 要保证排序的稳定性，因为要计算逆序对的个数
            if (nums[i] <= nums[j]){
                temp[idx] = nums[i];
                i++;
                res += j - mid - 1;
            }else {
                temp[idx] = nums[j];
                j++;
            }
        }
        for (int idx = 0; idx <= end - start; idx++){
            nums[start + idx] = temp[idx];
        }
        return res;
    }

    public int mergeSort(int[] nums, int start, int end){
        if (start >= end){
            return 0;
        }
        int mid = start + (end - start) / 2;
        int leftPairs = mergeSort(nums, start, mid);
        int rightPairs = mergeSort(nums, mid + 1, end);

        //如果左半部分最后一个小于=右半部分第一个，那就不用合并了
        if (nums[mid] <= nums[mid + 1]){
            return leftPairs + rightPairs;
        }

        int crossPairs = merge(nums, start, mid, end);
        return leftPairs + rightPairs + crossPairs;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
