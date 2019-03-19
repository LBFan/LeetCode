package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2018/10/20.
 * 题目：
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

public class One {
    public static int[] twoSum(int[] nums, int target) {
        int s[] = {0,0};
        for(int i = 0;i <nums.length; i++){
            for (int j = i + 1 ; j < nums.length; j++) {
                if (target == nums[i] + nums[j]){
//                    System.out.println("[" + i + "," + j + "]");
                    s[0] = i;s[1] = j;
                    break;
                }
            }

        }
        if(s[0] < 0 || s[1] <= 0){
            return null;
        }
        return s;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] indexs = twoSum(nums, target);
        if (indexs.length > 1) {
            System.out.println("[" + indexs[0] + "," + indexs[1] + "]");
        }

    }
}

