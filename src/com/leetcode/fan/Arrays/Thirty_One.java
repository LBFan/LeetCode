package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2018/10/30.
 * <p>
 * <p>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * <p>
 * 这道题让我们求下一个排列顺序，有题目中给的例子可以看出来，如果给定数组是降序，
 * 则说明是全排列的最后一种情况，则下一个排列就是最初始情况。我们再来看下面一个例子，有如下的一个数组
 * <p>
 * 1　　2　　7　　4　　3　　1
 * <p>
 * 下一个排列为：
 * <p>
 * 1　　3　　1　　2　　4　　7
 * <p>
 * 那么是如何得到的呢，我们通过观察原数组可以发现，如果从末尾往前看，数字逐渐变大，到了2时才减小的，
 * 然后我们再从后往前找第一个比2大的数字，是3，那么我们交换2和3，再把此时3后面的所有数字转置一下即可，步骤如下：
 * <p>
 * 1　　2　　7　　4　　3　　1
 * <p>
 * 1　　2　　7　　4　　3　　1
 * <p>
 * 1　　3　　7　　4　　2　　1
 * <p>
 * 1　　3　　1　　2　　4　　7
 */

public class Thirty_One {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i])
            i--;

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);

        }
        reverse(nums, i + 1);

    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 5};
        new Thirty_One().nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

