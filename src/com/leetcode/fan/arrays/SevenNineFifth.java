package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/14.
 */

public class SevenNineFifth {
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        if (A == null || A.length < 1) {
            return 0;
        }
        int le = -1, ri = -1;
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {
                le = i;
            } else if (A[i] >= L) { // L <= A[i] <= R
                ri = i;
            }

            if (le < ri) {
                count += ri - le;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3};
        int L = 2, R = 3;
        int count = numSubarrayBoundedMax(arr, L, R);
        System.out.println(count);
    }
}

