package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2018/10/31.
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */

public class Thirty_Five {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int index = 0;
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1) {
            if (nums[0] < target)
                return 1;
            else
                return 0;
        }
        while (lo <= hi) {
            if (nums[lo] >= target) {
                index = lo;
                break;
            }

            if(nums[hi] < target){
                index =  hi + 1;
                break;
            }

            if (nums[lo] < target && target <= nums[lo + 1]){
                index = lo + 1;
                break;
            }

            if (nums[hi] >= target && target > nums[hi - 1]){
                index = hi;
                break;
            }

            int middle = (lo + hi) >> 1;
            if (target > nums[lo] && target > nums[lo + 1])
                lo = lo + 1;
            if (target < nums[hi] && target < nums[hi - 1])
                hi = hi -1;
        }
        return  index;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        int index = new Thirty_Five().searchInsert(nums, target);
        System.out.println(index);
    }
}

