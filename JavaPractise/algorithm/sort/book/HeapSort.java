package algorithm.sort.book;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/10
 *
 * leetcode 215题
 * 堆排序解法
 */

public class HeapSort {

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--){
            swap(nums, i, 0);
            heapSize--;

            //注意，这里是对数组的第一个元素重新做heapify
            heapify(nums, 0, heapSize);
        }

        //注意，这里返回的是nums[0]
        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int heapSize){
        for (int i = (nums.length - 1) / 2; i >= 0; i--){
            heapify(nums, i, heapSize);
        }
    }

    public void heapify(int[] nums, int i, int heapSize){
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int maxIndex = i;

        //注意这里是maxIndex而不是i
        if (leftChild < heapSize && nums[leftChild] > nums[maxIndex]){
            maxIndex = leftChild;
        }
        //注意这里是maxIndex而不是i
        if (rightChild < heapSize && nums[rightChild] > nums[maxIndex]){
            maxIndex = rightChild;
        }

        if (maxIndex != i){
            swap(nums, maxIndex, i);
            heapify(nums, maxIndex, heapSize);
        }
    }


    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
