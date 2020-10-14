package algorithm.sort.book;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/02
 *
 * 每一轮选取未排定的部分中最小的部分交换到未排定部分的最开头
 * 经过若干个步骤，就能排定整个数组。即：先选出最小的，再选出第 2 小的，以此类推。
 */

public class SelectSort {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void selectSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }
}
