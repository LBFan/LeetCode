package com.leetcode.fan.arrays;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/04.
 */

public class SixOneOne {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int right = nums.length - 1;
        int result = 0;
        for (int index = 0; index < nums.length; index++) {
            int targetIndex = right - index;
            result += findLegalThreeEdge(nums, 0, targetIndex - 1, nums[targetIndex]);
        }
        return result;
    }

    private static int findLegalThreeEdge(int[] nums, int left, int right, int target) {
        int count = 0;
        while (left < right) {
            /// 三角形：两边之和大于第三边
            /// 如果 left + right > target 则说明 > left 的边 + right 都可以与 target 组成三角形
            if (nums[left] + nums[right] > target) {
                count += right - left;
                right--;
            } else {
                /// 两边之和小于第三边，则增加下最短的边，left++，查看下第一个大于当前边的边是否与 right，target 组成三角形
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        SixOneOne sixOneOne = new SixOneOne();
        int count = sixOneOne.triangleNumber(nums);
        System.out.println("最多能构成的三角形个数为：" + count);
    }
}

