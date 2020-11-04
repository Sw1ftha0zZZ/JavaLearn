package algorithm.array.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/11/2
 */

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num: nums1) {
            set1.add(num);
        }

        for (int num: nums2) {
            set2.add(num);
        }

        return commonSet(set1, set2);
    }

    public int[] commonSet(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return commonSet(set2, set1);
        }

        Set<Integer> ans = new HashSet<>();

        for (int num: set1) {
            if (set2.contains(num)) {
                ans.add(num);
            }
        }

        int[] ansArray = new int[ans.size()];
        int index = 0;
        for (int n: ans) {
            ansArray[index] = n;
            index++;
        }
        return ansArray;
    }

    //排序 + 双指针
    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[len1 + len2];

        int index = 0;
        int index1 = 0;
        int index2 = 0;

        while (index1 < len1 && index2 < len2) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];

            if (num1 == num2) {
                if (index == 0 || ans[index - 1] != num1) {

                    ans[index] = num1;
                    index++;
                }
                index1++;
                index2++;
            }else if (num1 > num2) {
                index2++;
            }else {
                index1++;
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }
}
