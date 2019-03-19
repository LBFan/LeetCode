package com.leetcode.fan.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (map.containsKey(rest) && map.get(rest) != i) {
                // return new int[] { map.get(rest), i };
                return new int[] { i, map.get(rest) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    public static void main(String[] args) {
		TwoSumSolution tSolution = new TwoSumSolution();
		int[] nums = {1,2,3,5,7,10};
		int target = 9;
		String str = "";
		int strnum;
		int[] result = tSolution.twoSum(nums, target );
		System.out.print("[ ");
		for (int i = 0; i < result.length; i++) {
			strnum = result[i];
			str += String.valueOf(strnum);
			str += ", ";
		}
		int NO = str.length();
		str = str.substring(0, NO-2);
		System.out.print(str);
		System.out.println(" ]");
		}
}