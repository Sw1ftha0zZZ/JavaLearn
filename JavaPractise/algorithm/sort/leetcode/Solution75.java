package algorithm.sort.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/10
 *
 * 2020/10/07
 *
 * 荷兰国旗
 *
 * 三路快排
 *
 */

public class Solution75 {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return;
        }

        //双指针
        int first = 0;
        int second = len - 1;

        //注意这里i是小于等于第二个指针的，第二个指针是会变的
        for (int i = 0; i <= second; i++) {

            //i是自动会做+1的
            if (nums[i] == 0) {
                swap(nums, i, first);
                first++;
            }

            //把最后一个和i换过来，然后把最后一个往前指，就认为需要排序的少了一个
            if (nums[i] == 2) {
                swap(nums, i, second);
                second--;

                //因为在for循环中i自动会做+1，这里还需要判断换回来的这个i，所以在这做个-1
                //i == 0的情况，减一后还是可以进入循环的，进入循环又被初始化为0
                i--;
            }
        }
    }

}
