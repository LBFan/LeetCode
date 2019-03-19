package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2018/12/20.
 * <p>
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */

public class TwoSixEight {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i :nums)
            sum+=i;
        return (((int)Math.pow(n,2)+n)-2*sum)/2;
        // 利用公式 (1+2+ ... + n) - sum
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        int out = new TwoSixEight().missingNumber(nums);
        System.out.println(out);
    }
}

