package com.leetcode.fan.Arrays;

import java.util.Arrays;

/**
 * Created by : PF
 * Date on : 2018/11/16.
 */

public class Eighty {
    public int removeDuplicates(int[] nums) {
        int repeat = 2;
        if (nums.length <= repeat) {
            return nums.length;
        }

        int len = 1; // 结果数组长度
        int count = 1; // 记录重复数字个数
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[len - 1]) { // 第len个数字不等于第(i+1)个数字
                count = 1; // 两个数不相等，计重复数数为1
                nums[len++] = nums[i];
            } else { // 第len个数字等于第(i+1)个数字
                count++;
                if (count > repeat) { // 如果重复数大于2
                    continue;// (回到for循环：i++)
                } else { // 如果重复数不大于2
                    nums[len++] = nums[i];
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2};
        int result = new Eighty().removeDuplicates(nums);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

