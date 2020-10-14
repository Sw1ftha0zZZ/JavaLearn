package algorithm.sort.book;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/02
 */

public class InsertSort {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void insertSort(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > nums[j]){
                    swap(nums, j, j - 1);
                }else {
                    break;
                }
            }
        }
    }
}
