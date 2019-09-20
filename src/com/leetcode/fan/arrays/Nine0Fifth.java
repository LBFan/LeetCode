package com.leetcode.fan.arrays;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/20.
 */

public class Nine0Fifth {
    public static int[] sortArrayByParity(int[] A) {
        // 构造一个数组，偶数从0开始放，奇数从后往前放
        int[] res = new int[A.length];
        int i = 0, j = A.length - 1;
        for (int h = 0; h < A.length; h++) {
            if (A[h] % 2 == 0) {
                res[i++] = A[h];
            } else {
                res[j--] = A[h];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {3,1,2,4};
        int[] res = sortArrayByParity(A);
        Arrays.stream(res).forEach(e -> System.out.println(e));
    }
}

