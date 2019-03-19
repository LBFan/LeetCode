package com.leetcode.fan.Arrays;

import java.util.Arrays;

/**
 * Created by : PF
 * Date on : 2018/11/13.
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */

public class Seventy_Five {
    //计算出0，1，2的个数，然后分别录入
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] counts = new int[3];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
//        for(int j = 0; j < nums.length; j++) {
//            while(counts[k] == 0 && k < 3)
//                k++;
//            nums[j] = k;
//            counts[k]--;
//        }
        int j = 0, k = 0, h = 0;
        for (;j < counts[0]; j++) {
            nums[j] = 0;
        }

        for (; k < counts[1]; k++) {
            nums[j + k] = 1;
        }

        for (; h < counts[2]; h++) {
            nums[j + k + h] = 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new Seventy_Five().sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}

