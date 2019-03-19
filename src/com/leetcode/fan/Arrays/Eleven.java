package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2018/10/30.
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */

public class Eleven {

    public int maxArea(int[] height) {

        int size = height.length;
        if(size < 2){
            return 0;
        }
        int i = 1, j = size;
        int mArea = 0;
        while(i < j){
            int temp = (j - i) * (height[i - 1] >= height[j - 1] ? height[j - 1] : height[i - 1]);
            if (temp >= mArea) {
                mArea = temp;
            }
            if(height[i - 1] > height[j - 1]){
                j = j - 1;
            } else{
                i = i + 1;
            }
        }
        return mArea;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int area = new Eleven().maxArea(nums);
        System.out.println("the maxArea of the capocity is :" + area);
    }
}

