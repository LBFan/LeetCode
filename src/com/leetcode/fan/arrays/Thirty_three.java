package com.leetcode.fan.arrays;

/**
 * Created by : PF
 * Date on : 2018/10/30.
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例1：
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例2：
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */

public class Thirty_three {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            if (target == nums[lo])
                return lo;
            if (target == nums[hi])
                return hi;

            int middle = (lo + hi) >> 1;
            if (target == nums[middle]) {
                return middle;
            }

            if (nums[lo] > nums[middle]) {
                if(target > nums[middle] && nums[lo] > target)
                    lo = middle + 1;
                else
                    hi = middle - 1;
            } else {
                if (nums[middle] > target && target > nums[lo])
                    hi = middle - 1;
                else
                    lo = middle + 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] numbers = {4,5,6,7,0,1,2};
        int targetOne = 0;
        int indexOne = new Thirty_three().search(numbers,targetOne);
        System.out.printf("the index of 0 in numbers is :" + indexOne);
        System.out.println();
        int targetTwo = 3;
        int indexTwo = new Thirty_three().search(numbers,targetTwo);
        System.out.printf("the index of 0 in numbers is :" + indexTwo);

    }
}

