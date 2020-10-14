package algorithm.array.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/03
 */

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[m + n];
        int i = 0;
        int j = 0;
        for (int idx = 0; idx < m + n; idx++){
            if (j >= n){
                num[idx] = nums1[i];
                i++;
                continue;
            }
            if (i >= m){
                num[idx] = nums2[j];
                j++;
                continue;
            }
            if (nums1[i] <= nums2[j]){
                num[idx] = nums1[i];
                i++;
            }else {
                num[idx] = nums2[j];
                j++;
            }
        }
        for (int idx = 0; idx < m + n; idx++){
            nums1[idx] = num[idx];
        }
    }
}
