package com.leetcode.fan.DP;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/11/01.
 */

public class MaxIncreasingSeq {

    private static int maxLen(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1; // 哨兵
        for (int i = 1; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] >= max) {
                    max = dp[j] + 1;
                }
            }
            dp[i] = max;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {2, 9, 3, 6, 5, 1, 7};
        int maxLen = maxLen(arr);
        System.out.println(maxLen);
    }
}

