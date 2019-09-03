package com.leetcode.fan.arrays;

/**
 * Created by : PF
 * Date on : 2019-07-08.
 * 697. 数组的度
 * 思路 ：
 * 找出 nums 中最大数字 max
 * 分别初始化三个数组，mapSize[max + 1],mapMax[max + 1],mapMin[max + 1]
 * mapSize存放nums中每个数字出现的次数。例如 2在nums数组中出现了3次，那么，mapSize[2] = 3
 * mapMax 存放nums中每个数字最后一次出现在nums中的下标位置。例如2在nums中最后一次出现在nums数组的第7个位置，那么mapMax[2] = 6
 * mapMin 存放nums中每个数字第一次出现在nums中的下标位置。例如2在nums中第一次出现在nums数组的第2个位置，那么mapMin[2] = 1
 */

public class SixNineSeven {
    public static int findShortestSubArray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            // nums中的最大数
            max = Math.max(max, num);
        }
        // map数组的大小
        int[] mapSize = new int[max + 1];
        int[] mapMin = new int[max + 1];
        int[] mapMax = new int[max + 1];
        int maxSize = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (mapSize[num] == 0) {
                mapMin[num] = i;
                mapMax[num] = i;
            } else {
                mapMax[num] = i;
            }
            maxSize = Math.max(maxSize, ++mapSize[num]);
        }
        int ans = Integer.MAX_VALUE;
        int temp = 0;
        for (int num = 0; num <= max; num++) {
            if (maxSize == mapSize[num]) {
                ans = Math.min(ans, mapMax[num] - mapMin[num] + 1);
                System.out.println("度 ： " + ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]  nums = {1,2,2,3,3,4};
        int res = findShortestSubArray(nums);
//        System.out.println(res);
    }
}

