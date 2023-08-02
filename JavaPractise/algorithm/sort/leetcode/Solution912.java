package algorithm.sort.leetcode;

import java.util.Random;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/28
 *
 * 塔罗兔的模板
 * 快排 + 归并（归并可以对比148题）
 *
 * 快排的pivot其实选在哪都是可以的，看个人喜好，这里我们将pivot选在第一个点
 *
 */

public class Solution912 {

    //快排
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    Random rand = new Random();
    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int randIndex = start + rand.nextInt(end - start + 1);
        swap(nums, start, randIndex);

        int pivot = nums[start];
        int left = start + 1;
        int right = end;

        while (left <= right) {
            if (nums[left] <= pivot) {
                left++;
                continue;
            }
            if (nums[right] >= pivot) {
                right--;
                continue;
            }
            swap(nums, left, right);
        }
        swap(nums, start, right);
        quickSort(nums, start, right - 1);
        quickSort(nums, left, end);
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }






    //归并
    public void merge(int[] nums, int start, int mid, int end){
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        for (int idx = 0; idx <= end - start; idx++){
            //如果左边的数组已经越界
            if (i > mid){
                temp[idx] = nums[j];
                j++;
                //这个地方是要加continue的，不然比较nums[i]和nums[j]的代码会执行
                continue;
            }
            //如果右边的数组已经越界
            if (j > end){
                temp[idx] = nums[i];
                i++;
                //这个地方是要加continue的，不然比较nums[i]和nums[j]的代码会执行
                continue;
            }
            if (nums[i] <= nums[j]){
                temp[idx] = nums[i];
                i++;
            }else {
                temp[idx] = nums[j];
                j++;
            }
        }
        for (int idx = 0; idx <= end - start; idx++){
            //注意这个地方是nums[start + idx]
            nums[start + idx] = temp[idx];
        }
    }

    public void mergeSort(int[] nums, int start, int end){
        if (start >= end){
            return;
        }
        //这样写防止溢出
        int mid = start + (end - start) / 2;
        // Java 里有更优的写法，在 left 和 right 都是大整数时，即使溢出，结论依然正确
        // int mid = (left + right) >>> 1;

        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public int[] sortArray1(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }



    //堆排序，把数组按下标存储成堆的形式
    public void heapSort(int[] nums) {
        int heapSize = nums.length;
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            heapSize--;
            heapify(nums, 0, heapSize);
        }
    }

    public void buildMaxHeap(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }
    }

    public void heapify(int[] nums, int idx, int heapSize) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        int maxIndex = idx;
        // 这里是和maxIndex比
        if (left < heapSize && nums[left] > nums[maxIndex]) {
            maxIndex = left;
        }
        // 这里是和maxIndex比
        if (right < heapSize && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != idx) {
            swap(nums, idx, maxIndex);
            heapify(nums, maxIndex, heapSize);
        }
    }


    public int[] sortArray3(int[] nums) {
        heapSort(nums);
        return nums;
    }

}
