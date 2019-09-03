package com.leetcode.fan.arrays;

import static java.lang.StrictMath.max;

/**
 * Created by : PF
 * Date on : 2018/11/5.
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * <p>
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */

public class Fifty_five {

    // dynamic method
//    public boolean canJump(int[] nums) {
//        if (nums.length == 1) return true;
//
//        int [] dp = new int[nums.length];
//        dp[0] = nums[0];
//        for (int i = 1; i < dp.length; ++i) {
//            if (dp[i-1] >= i)
//                dp[i] = max(nums[i]+i, dp[i-1]);
//            else
//                dp[i] = 0;
//        }
//        return dp[dp.length-1] >= nums.length-1;
//    }

    // 贪心算法
    public boolean canJump(int[] nums) {
        int currMaxStep = nums[0]; //当前能够跳跃的最大步数
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > currMaxStep)
                return false;
            currMaxStep = max(currMaxStep, i + nums[i]);
            if (currMaxStep >= nums.length - 1)
                return true;
        }
        return currMaxStep >= nums.length - 1;
    }

    public static void main(String[] args) {
//        int[] nums = {3,2,2,0,4};
        int[] nums = {0};
        boolean result = new Fifty_five().canJump(nums);
        System.out.println(result);
    }
}

