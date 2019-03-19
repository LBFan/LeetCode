package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2018/12/20.
 */

public class TwoEightThree {

    public void moveZeroes(int[] nums) {
        // 从左向右依次遍历 遇到0就交换位置 计数0的个数
        int c0 = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                if (nums[i + 1] != 0) {
                    int t = nums[i + 1];
                    nums[i + 1] = nums[i + 1 - c0];
                    nums[i + 1 - c0] = t;
                } else if (nums[i + 1] == 0) {
                    c0 += 1;
                }
            }
        }

    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        new TwoEightThree().moveZeroes(nums);
        for (int a :
                nums) {
            System.out.print(a + " ");
        }
    }
}

