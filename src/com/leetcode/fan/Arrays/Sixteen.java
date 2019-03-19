package com.leetcode.fan.Arrays;

import java.util.Arrays;

/**
 * Created by : PF
 * Date on : 2018/11/1.
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */

public class Sixteen {
    public int threeSumClosest(int[] nums, int target) {

        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;

            while (start < end) {
                int tmpSum = nums[i] + nums[start] + nums[end];
                if (Math.abs(tmpSum - target) < Math.abs(result - target))
                    result = tmpSum;
                if (tmpSum < target)
                    start++;
                else if (tmpSum > target)
                    end--;
                else
                    return result;

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2,1,-4};
        int target = 1;
        int res = new Sixteen().threeSumClosest(nums, target);
        System.out.println(res);
    }
}

