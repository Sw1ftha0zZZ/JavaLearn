package algorithm.greedy.leetcode;


/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/24
 */


public class Solution1024 {
    public int videoStitching(int[][] clips, int T) {
        if (clips == null) {
            return -1;
        }
        //初始化T个元素的数组
        //用于保存以当前数字为下标的最大可达位置
        //数组元素是从0到T- 1的，没有包括T
        int[] maxEnd = new int[T];

        //对每个点求最大可达位置
        for (int[] clip: clips) {
            //只对严格小于T的位置求最大可达位置
            if (clip[0] < T) {
                maxEnd[clip[0]] = Math.max(maxEnd[clip[0]], clip[1]);
            }
        }

        int pre = 0;//在所有已经被添加的区间中的最大可达位置
        int last = 0;//当前点的理论最大可达位置
        int count = 0;

        for (int i = 0; i < T; i++) {
            last = Math.max(maxEnd[i], last);

            //因为最大可达数组是没有包括T的，所以这里直接这样写
            if (i == last) {
                return -1;
            }

            if (i == pre) {
                count++;
                pre = last;
            }

        }
        return count;
    }



    public static void main(String[] args) {

        int[][] nums = {{0, 2}, {1, 5}, {1, 9}, {4, 6}, {5, 9}, {8, 10}};
        System.out.println(new Solution1024().videoStitching(nums, 10));
//        Arrays.sort(nums, (int[] a, int[] b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
//        System.out.println(nums[0][0]);
    }
}
