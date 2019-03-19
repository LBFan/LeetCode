package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2018/12/20.
 */

public class TwoThreeEight {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) { // 从左向右遍历
            output[i] = output[i - 1] * nums[i - 1];
        }

        int ri = 1;
        for (int j = nums.length - 1; j >= 0; j--) { // 从右向左遍历
            output[j] *= ri;
            ri *= nums[j];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] output = new TwoThreeEight().productExceptSelf(nums);
        System.out.print("[");
        for (int out :
                output) {
            System.out.print(" " + out);
        }
        System.out.print("]");
    }
}

