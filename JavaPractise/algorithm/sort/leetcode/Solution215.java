package algorithm.sort.leetcode;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/28
 *
 * 方法1：quickSelect
 * 不稳定，但是最优情况好
 *
 * 方法2：基于堆，优先队列
 * 稳定 o(nlogn)
 */

public class Solution215 {

    //快排，随机化pivot
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    Random rand = new Random();
    public void quickSelect(int[] nums, int k, int start, int end){
        if (start >= end){
            return;
        }
        int randomIndex = start + rand.nextInt(end - start + 1);
        swap(nums, randomIndex, start);
        int pivot = nums[start];
        int l = start + 1;
        int r = end;
        while (l <= r){
            if (nums[l] >= pivot){
                l++;
                continue;
            }
            if (nums[r] <= pivot){
                r--;
                continue;
            }
            swap(nums, l, r);
        }
        swap(nums, start, r);

        //注意左半部分是从nums[start]到nums[r],是包括nums[r]的，所以左半部分的长度是r-start+1
        //如果大于k，从start到r-1排序是因为nums[r]已经是在正确位置的pivot了，不需要再对他排序
        //当然也可以左半部分是从start到r排序，只不过会做一次没必要的排序
        if (r - start + 1 == k){
            return;
        }else if (r - start + 1 > k){
            quickSelect(nums, k, start, r - 1);
        }else {
            quickSelect(nums, k - (r - start + 1), l, end);
        }

    }
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, k, 0, nums.length - 1);
        return nums[k - 1];
    }



    ///////////////////////////////////////////////////////////////////////
    //优先队列
    //最大堆
    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (a,b) -> b - a);
        for (int i = 0; i < len; ++i) {
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++){
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    //最小堆
    public int findKthLargest2(int[] nums, int k){

        PriorityQueue<Integer> minHeap = new PriorityQueue<> ((a, b) -> a - b);
        for (int n : nums){
            minHeap.add(n);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
