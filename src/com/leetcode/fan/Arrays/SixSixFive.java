package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2019-07-07.
 */

public class SixSixFive {
    public static void main(String[] args) {
        int[] nums01 = {4,3,2,3};
        int[] nums02 = {4,2,3};

        SixSixFive sixFive = new SixSixFive();

        System.out.println("nums01 : " + sixFive.checkPossibility(nums01));
//        System.out.println("nums02 : " + sixFive.checkPossibility(nums02));
    }

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (count == 1)
                    return false;
                if ((i - 2 >= 0) && nums[i] < nums[i - 2]) {
                    nums[i] = nums[i - 1];
                }
                count++;
            }
        }
        return true;
    }
}

