package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :
 * title：
 * 数组 A 是 [0, 1, ..., N - 1] 的一种排列，N 是数组 A 的长度。
 * 全局倒置指的是 i,j 满足 0 <= i < j < N 并且 A[i] > A[j] ，
 * 局部倒置指的是 i 满足 0 <= i < N 并且 A[i] > A[i+1] 。
 * 当数组 A 中全局倒置的数量等于局部倒置的数量时，返回 true 。
 * @date : 2019/09/12.
 */

public class SevenSevenFifth {
    public static boolean isIdealPermutation(int[] A) {
        // int m = Integer.MIN_VALUE, midx = -1;
        // for (int i = 1; i < A.length; i++) {
        //     if (midx != i - 1 && m > A[i]) {
        //         return false;
        //     }
        //     if (A[i - 1] > m) {
        //         m = A[i - 1];
        //         midx = i - 1;
        //     }
        // }
        // return true;

        // method 2:
        if (A == null || A.length == 0) {
            return false;
        } else if (A.length == 1 || A.length == 2) {
            return true;
        }
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - i) >= 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2};
        boolean re = isIdealPermutation(arr);
        System.out.println(re);
    }
}

