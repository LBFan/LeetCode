package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2018/11/1.
 * <p>
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * <p>
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * 说明:
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */

public class Fourty_One {
    public int firstMissingPositive(int[] nums) {
        // write your code here
        if (nums == null) {
            return 1;
        }

        // 令数组下标和存的值产生联系-> 令数字i出现在下标为i-1的位置，如果会越界<即数组中的值i大于数组长度>则不做处理
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != (i + 1)) {
                int tmp = nums[nums[i] - 1];
                if (tmp == nums[i]) {
                    break;
                }
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;

    }

    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 11, 12};
        int res = new Fourty_One().firstMissingPositive(nums);
        System.out.println(res);
    }
}

