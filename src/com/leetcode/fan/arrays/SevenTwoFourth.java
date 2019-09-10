package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/10.
 */

public class SevenTwoFourth {
    public static int pivotIndex(int[] nums) {
        if(nums.length < 2)
            return -1;
        int leftSum = 0;
        int rightSum;
        int sum = 0;
        for(int n:nums){
            sum += n;
        }
        System.out.println(sum);
        int i;
        for(i=0;i<nums.length;i++){
            if(i==0)
                leftSum = 0;
            else
                leftSum += nums[i-1];
            rightSum = sum - leftSum - nums[i];
            if(leftSum == rightSum)
                return i;
        }
        System.out.println(i);
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,7,3,1,6,5};
        int mid = pivotIndex(nums);
        System.out.println(mid);
    }
}

