package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :
 * 从地面可以直接跃向第0级或第1级，花费分别为dp[0]=cost[0]、dp[1]=cost[1]，对于跨到2阶，可以从第0阶跨两步，耗费dp[0]+cost[2]；或者可以从第1阶跨一步，耗费dp[1]+cost[2]，所以，对于跨到第n层，可以从第dp[n-2]跨两步，或者从dp[n-1]跨一步，耗费cost[n]，求出dp[n-1]和dp[n-2]的最小值就可以得到爬到第n阶的最小耗费。
 * <p>
 * 状态转移方程为：dp[n] = Math.min(dp[n-1],dp[n-2]) + cost[n];
 * <p>
 * 最后比较从第n-1阶迈到楼顶的花费和从n-2阶迈到楼顶花费的最小值即可
 * @date : 2019/09/10.
 */

public class SevenFourSixth {
    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len+1];

        for(int i=2; i<=len; i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        return dp[len];
    }

    public static void main(String[] args) {
        int[] nums = {10, 15, 20};
        int min = minCostClimbingStairs(nums);
        System.out.println(min);
    }
}

