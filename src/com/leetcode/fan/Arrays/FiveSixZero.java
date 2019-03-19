package com.leetcode.fan.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by : PF
 * Date on : 2019/2/19.
 */

public class FiveSixZero {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap();
        int sum = 0;
        int result = 0;
        preSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1,2,1,2,2};
        int k = 5;
        int result = new FiveSixZero().subarraySum(nums, k);
        System.out.println(result);
    }
}

