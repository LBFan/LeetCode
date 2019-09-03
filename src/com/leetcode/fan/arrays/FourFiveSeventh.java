package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/03.
 */

public class FourFiveSeventh {
    private static boolean circularArrayLoop(int[] nums) {
        if (nums == null) return false;
        int round = 1000;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 1000) {
                continue;
            }
            boolean negative = nums[i] < 0;
            int length = 1;
            /** 找到下一跳的下标 */
            int nextIndex = (i + (nums[i] % nums.length) + nums.length) % nums.length;
            nums[i] = ++round;

            while (nums[nextIndex] <= 1000 && nums[nextIndex] != round && (nums[nextIndex] > 0 ^ negative)) {
                int temp = nextIndex;
                nextIndex = nextIndex + (nums[nextIndex] % nums.length);
                nextIndex += nums.length;
                nextIndex %= nums.length;
                if (temp == nextIndex) {
                    length = 1;
                    break;
                }
                nums[temp] = round;
                length++;
            }
            if (nums[nextIndex] != round && nums[nextIndex] > 0 == negative) {
                continue;
            }
            if (length > 1 && nums[nextIndex] == round) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -1, -2, -2};
        long start = System.currentTimeMillis();
        boolean result = circularArrayLoop(nums);
        System.out.println("result:" + result);
        long spendTime = System.currentTimeMillis() - start;
        System.out.println(spendTime);
    }
}

