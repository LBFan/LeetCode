package com.leetcode.fan.arrays;

/**
 * Created by : PF
 * Date on : 2018/11/2.
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */

public class Fourty_Two {

    public int trap(int[] height) {
        if (height == null || height.length <= 2)
            return 0;
        int maxL = height[0];
        int[] maxRs = new int[height.length];
        int waterSum = 0;//计算总的水量
        int maxR = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > maxR) {
                maxRs[i] = maxR = height[i];
            } else {
                maxRs[i] = maxR;
            }
        }
        for (int i = 1; i < height.length - 1; i++) {
            if (height[i] > maxL) {
                maxL = height[i];//更新左边最大值
            }
            waterSum += Math.max(Math.min(maxL, maxRs[i]) - height[i], 0);
        }
        return waterSum;

    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int waterSum = new Fourty_Two().trap(nums);
        System.out.println(waterSum);
    }

}

