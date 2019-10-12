package com.leetcode.fan.DP;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/10.
 */

public class NineSixth {
    // DP
    public static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];

        // 数学演绎法
//        // Note: we should use long here instead of int, otherwise overflow
//        long C = 1;
//        for (int i = 0; i < n; ++i) {
//            C = C * 2 * (2 * i + 1) / (i + 2);
//        }
//        return (int) C;
    }

    public static void main(String[] args) {
        int n = 4;
        int i = numTrees(n);
        System.out.println(i);
    }
}

