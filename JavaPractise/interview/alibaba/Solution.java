package interview.alibaba;

import java.util.*;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/03/01
 */

public class Solution {
    /*
    【1】给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
    使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
    示例：
    给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    满足要求的三元组集合为：
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
    */
    public List<List<Integer>> threeSum (int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

/*
【2】有一个字符串它的构成是词+空格的组合，如“北京 杭州 杭州 北京”， 要求输入一个匹配模式（简单的以字符来写），
比如 aabb, 来判断该字符串是否符合该模式，
示例：
pattern = "abba", str="北京 杭州 杭州 北京" 返回 true
pattern = "aabb", str="北京 杭州 杭州 北京" 返回 false
pattern = "baab", str="北京 杭州 杭州 北京" 返回 true
*/
    public boolean verfy(String pattern, String str) {
        String[] strArray = str.split(" ");
        if (strArray.length != pattern.length()) {
            return false;
        }
        if (str == null) {
            return false;
        }
        if (str.length() == 0 && (pattern == null || pattern.length() == 0)) {
            return true;
        }
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < strArray.length; i++) {
            if (!map.containsKey(strArray[i])) {
                map.put(strArray[i], pattern.charAt(i));
            } else {
                Character c = map.get(strArray[i]);
                if (c != pattern.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.verfy("aabb", "北京 杭州 杭州 北京"));
    }

}
