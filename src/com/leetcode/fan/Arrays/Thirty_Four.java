package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2018/10/31.
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */

public class Thirty_Four {
    public int[] searchRange(int[] nums, int target) {
        int[] outs = new int[2];
        for (int i = 0; i < outs.length; i++) {
            outs[i] = -1;
        }

        // 考虑问题的全面性
        if (nums.length == 1) {
            if (nums[0] == target) {
                outs[0] = 0;
                outs[1] = 0;

                return outs;
            } else {
                return outs;
            }
        }

        if (nums == null || nums.length == 0) {
            return outs;
        }
        int flag1 = 0, flag2 = 0;
        int lo = 0, hi = nums.length - 1;

        // 二分法查找 ，使得算法时间复杂度为O(LOG(N))级
        while (lo <= hi) {
            int middle = (lo + hi) >> 1;
            if (target == nums[lo] && flag1 == 0) {
                outs[0] = lo;
                flag1++;
            }

            if (target == nums[hi] && flag2 == 0) {
                outs[1] = hi;
                flag2++;
            }

            if (flag1 > 0 && flag2 > 0)
                break;

            if (nums[middle] > target) {
                hi = middle - 1;
            } else if (nums[middle] < target) {
                lo = middle + 1;
            } else {
                if (flag1 == 0) {
                    lo++;
                }
                if (flag2 == 0) {
                    hi--;
                }
            }
        }
        return outs;

    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] indexs = new Thirty_Four().searchRange(nums, target);
        System.out.print("[" + indexs[0] + "," + indexs[1] + "]");
    }
}

