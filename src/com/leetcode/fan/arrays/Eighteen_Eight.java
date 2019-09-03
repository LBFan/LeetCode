package com.leetcode.fan.arrays;

import java.util.Arrays;

/**
 * Created by : PF
 * Date on : 2018/11/13.
 */

public class Eighteen_Eight {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null && nums2 == null) {
            return;
        }
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 3, 6};
        new Eighteen_Eight().merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

}

