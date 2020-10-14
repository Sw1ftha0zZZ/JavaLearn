package algorithm.sort.book;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/02
 */

public class BubbleSort {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void bubbleSort(int[] nums){
        int length = nums.length;
        for (int i = length - 1; i >= 0; i--) {
            //先默认数组是有序的，只要发生一次交换，就必须进行下一轮比较
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]){
                    swap(nums, j, j + 1);
                    sorted = false;
                }
            }
            if (sorted){
                break;
            }
        }
    }
}
