package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/04.
 */

public class FiveSixFive {
    private static int arrayNesting(int[] nums) {
        // 时间复杂度应该在o(n^2)
        int num, res = 1, count = 1, temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                num = nums[i];
                while (num != i) {
                    temp = num;
                    num = nums[num];
                    nums[temp] = -1;
                    count++;
                }
                res = Math.max(res, count);
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
        int maxLen = arrayNesting(nums);
        System.out.println(maxLen);
    }
}

