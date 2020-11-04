package algorithm.binarySearch.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/14
 *
 * LC 300的二维扩展
 * 同时注意Comparator的写法
 *
 * 因为要套娃，所以宽度一样的时候，按照高度降序排列。
 *
 * 对高度数组做LIS
 */

public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if (len <= 1){
            return len;
        }

//        Arrays.sort(envelopes, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a, int[] b) {
//                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
//            }
//        });

        Arrays.sort(envelopes, (int[] a, int[] b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] height = new int[len];
        for (int i = 0; i < len; i++){
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }

    public int lengthOfLIS(int[] nums){
        int len = nums.length;
        if (len <= 1){
            return len;
        }

        //tail数组用于保存原数组中的上升子序列
        int[] tail = new int[len];
        //init
        tail[0] = nums[0];
        //end是tail数组最后一个已被赋值的元素的index
        int end = 0;

        for (int i = 1; i < len; ++i) {
            //如果遍历到的nums[i]比tail[end]大，就end++，并将tail最后一个元素赋值
            if (nums[i] > tail[end]){
                end++;
                tail[end] = nums[i];
            }else {
                //二分法找nums[i]应该放在**tail数组**中的哪个位置
                int left = 0;
                int right = end;
                while (left < right) {
                    int mid = left + (right - left) / 2;

                    //要找的是放在tail数组中的哪里，nums[i]相当于target
                    //判断条件是tail[mid] < target
                    if (tail[mid] < nums[i]){
                        left = mid + 1;
                    }else {
                        right = mid;
                    }
                }
                // 走到这里是因为 【逻辑 1】 的反面，因此一定能找到第 1 个大于等于 nums[i] 的元素
                // 因此，无需再单独判断
                tail[left] = nums[i];
            }


        }

        //返回长度，所以+1
        return end + 1;
    }

    public static void main(String[] args) throws InterruptedException {
        Set<Integer> set =  new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        set.add(1);
        set.add(5);
        set.add(2);
        //new Thread().sleep(100000);
        System.out.println(set);
    }
}
