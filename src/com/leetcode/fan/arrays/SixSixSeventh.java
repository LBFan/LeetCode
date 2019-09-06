package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/05.
 */

public class SixSixSeventh {
    public static int[] constructArray(int n, int k) {
        int left = 1;
        int right = k + 1;
        int[] ans = new int[n];
        int index = 0;
        while (left <= right) {
            ans[index++] = left++;
            if (left <= right)
                ans[index++] = right--;
        }
        for (int i = k + 2; i <= n; i++)
            ans[index++] = i;
        return ans;
    }

    public static void main(String[] args) {
        int n = 6, k = 4;
        int[] result = constructArray(n, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
        System.out.println();
    }
}

