package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2019-03-20.
 */

public class SixFourThree {
    public double findMaxAverage(int[] nums, int k) {
        // 双向指针法
        int max = 0;
        for (int i = 0; i < k;i++) {
            max += nums[i];
        }
        int sum = max;
        int len = nums.length;
        for (int i = 1; i <= len - k; i++) {
            sum -= nums[i - 1];
            sum += nums[i + k - 1];
            max = Math.max(max, sum);
        }
        return (double)max / k;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double result = new SixFourThree().findMaxAverage(nums, k);
        System.out.println(result);
    }
}

