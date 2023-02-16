package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luo
 * @date 2023/2/13 16:54
 */
public class Sum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}

