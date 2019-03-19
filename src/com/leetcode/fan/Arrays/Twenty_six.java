package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2018/10/30.
 *
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */

public class Twenty_six {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                // i++;
                nums[++i] = nums[j];
            }
        }
        return i + 1;

        // methods No.2:
//        if (nums.length < 2) {
//            return nums.length;
//        }
//        int len = 0;
//        for (int n : nums) {
//            if (len < 1 || n > nums[len - 1]) {
//                nums[len] = n;
//                len++;
//            }
//        }
//        return len;
    }

    public static void main(String[] args) {
        int[] arrs ={0,0,1,1,1,2,2,3,3,4};
        int len = new Twenty_six().removeDuplicates(arrs);
        for (int i = 0; i < len; i++) {
            System.out.println(arrs[i]);
        }
    }
}

