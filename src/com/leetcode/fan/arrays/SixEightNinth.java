package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/06.
 */

public class SixEightNinth {
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums.length < k * 3) {
            return null;
        }
        int n = nums.length;
        //计算和，因为入参都是正数，所以不需要初始化sums，否则可以都初始化为Integer.MIN_VALUE;
        int[] sums = new int[n];
        //这步可以优化
        //0,1 1,2  2,3 3,4  4,5 5,6
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k) sum -= nums[i - k];
            if (i >= k - 1) sums[i - k + 1] = sum;
        }

        //与左边的数组比较
        int[] left = new int[n - k + 1];
        int best = 0;
        for (int i = 0; i < left.length; i++) {
            if (sums[i] > sums[best]) best = i;
            left[i] = best;
        }

        //跟右边的数组比较
        int[] right = new int[n - k + 1];
        best = right.length - 1;
        for (int i = right.length - 1; i >= 0; i--) {
            if (sums[i] >= sums[best]) best = i;
            right[i] = best;
        }

        int idx1 = -1, idx2 = -1, idx3 = -1;
        for (int j = k; j < right.length - k; j++) {
            int l = left[j - k], r = right[j + k];
            if (idx1 == -1 || (sums[idx1] + sums[idx2] + sums[idx3] < sums[l] + sums[j] + sums[r])) {
                idx1 = l;
                idx2 = j;
                idx3 = r;
            }
        }
        return new int[]{idx1, idx2, idx3};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        int[] result = maxSumOfThreeSubarrays(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
    }
}

