package com.leetcode.fan.arrays;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 二分查找 + 双指针
 * <p>
 * 我们可以使用双指针来计算出所有小于等于 guess 的距离对数目。
 * 我们维护 left 和 right，其中 right 通过循环逐渐递增，left 在每次循环中被维护，
 * 使得它满足 nums[right] - nums[left] <= guess 且最小。这样对于 nums[right]，
 * 以它为右端的满足距离小于等于 guess 的距离对数目即为 right - left。
 * 我们在循环中对这些 right - left 进行累加，就得到了所有小于等于 guess 的距离对数目。
 * @date : 2019/09/10.
 */

public class SevenOneNinth {
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = (lo + hi) >> 1;
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; ++right) {
                while (nums[right] - nums[left] > mi) {
                    left++;
                }
                count += right - left;
            }
            //count = number of pairs with distance <= mi
            if (count >= k) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 6, 7, 7};
        int k = 1;
        int lo = smallestDistancePair(nums, k);
        System.out.println(lo);
    }
}

