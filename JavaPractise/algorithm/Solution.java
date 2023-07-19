package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        int len = nums.length;
        Arrays.sort(nums);

        for (int first = 0; first < len - 3; first++) {

            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            if ((long) nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
                break;
            }
            if ((long) nums[first] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }

            for (int second = first + 1; second < len - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                if ((long) nums[first] + nums[second] + nums[second + 1] + nums[second + 2] > target) {
                    break;
                }
                if ((long) nums[first] + nums[len - 1] + nums[len - 2] + nums[second] < target) {
                    continue;
                }

                int left = second + 1;
                int right = len - 1;

                while (right > left) {
                    if ((long) nums[second] + nums[first] + nums[left] + nums[right] == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[first]);
                        temp.add(nums[second]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        ans.add(temp);

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if ((long) nums[second] + nums[first] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }


                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,0,0,1000000000,1000000000,1000000000,1000000000};
        solution.fourSum(nums,1000000000);
    }
}