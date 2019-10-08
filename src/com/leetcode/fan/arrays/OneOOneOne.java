package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/30.
 */

public class OneOOneOne {
    public static int shipWithinDays(int[] weights, int D) {
        // binary search
        int lo = 0, hi = 0;
        for (int we :
                weights) {
            hi += we;
        }
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (canShip(weights, D, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static boolean canShip(int[] weights, int D, int K) {
        // cur 表示当前船的可用承载量
        int cur = K;
        for (int we :
                weights) {
            if (we > K) {
                return false;
            }
            if (cur < we) {
                cur = K;
                D--;
            }
            cur -= we;
        }
        // 能否在D天内运完
        return D > 0;
    }
}

