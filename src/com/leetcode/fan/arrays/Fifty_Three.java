package com.leetcode.fan.arrays;

import static java.lang.Integer.max;

/**
 * Created by : PF
 * Date on : 2018/11/4.
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */

public class Fifty_Three {

    // 使用动态规划法进行求解
//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int sum = 0, temp = 0;
//        if (nums.length == 1)
//            return nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            if (temp > 0) {
//                temp += nums[i];
//            } else {
//                temp = nums[i];
//            }
//
//            if (sum < temp) {
//                sum = temp;
//            }
//        }
//        return sum;
//    }

    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    int divide(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        if (l == r - 1) return max(nums[l], max(nums[r], nums[l] + nums[r]));

        int mid = (l + r) >> 1;
        int lret = divide(nums, l, mid - 1);
        int rret = divide(nums, mid + 1, r);

        int mret = nums[mid];
        int sum = mret;
        for (int i = mid - 1; i >= l; i--) {
            sum += nums[i];
            mret = max(mret, sum);
        }
        sum = mret;    //保存已经计算过的左边的最大子序和
        for (int i = mid + 1; i <= r; i++) {
            sum += nums[i];
            mret = max(mret, sum);
        }

        return max(lret, max(rret, mret));
    }


    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-1};

        int sum = new Fifty_Three().maxSubArray(nums);
        System.out.println(sum);
    }
}

