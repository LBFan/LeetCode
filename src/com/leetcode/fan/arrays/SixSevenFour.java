package com.leetcode.fan.arrays;

/**
 * Created by : PF
 * Date on : 2019-07-08.
 * 674. 最长连续递增序列
 */

public class SixSevenFour {
    public static int findLengthOfLCIS(int[] nums) {
        // 思路： 遍历数组，记录连续递增序列的长度temp，依次比较每个temp的大小，最大的temp即为要求的max值。
        int len = nums.length;
        if (len < 1) {
            return 0;
        }
        if (len < 2) {
            return 1;
        }
        int max = 1;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] < nums[i]) {
                count++;
            } else {
                count = 1;
            }
            max = (max > count) ? max : count;
        }

        return max;

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2, 5, 6, 7};
        int reurlt = findLengthOfLCIS(nums);
        System.out.println("最长递增序列： " + reurlt);

    }
}

