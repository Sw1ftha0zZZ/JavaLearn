package algorithm.binarySearch.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/13
 *
 * 排除法做二分查找
 * 思路：
 * 1.总是将待搜索区域分为两个部分：一部分一定不存在目标值，一部分可能存在目标值
 *
 * 2.根据mid被分到左边还是右边，有不同的更新策略
 *
 * 3.循环终止条件是while (left < right)，这样在退出循环的时候一定有：left==right。
 * 也就不用考虑是返回left还是返回right，返回哪个都一样。
 *
 * 4.在写if和else语句的时候，总是思考当Nums[mid]满足什么条件时，Nums[mid]不是目标元素，
 * 接着判断mid左边有没有可能存在目标元素，mid右边有没有可能存在目标元素
 */

public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }
        if (nums[len - 1] < target){
            return len;
        }

        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            //中间的值小于target，说明要插入的位置一定不在左边
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
