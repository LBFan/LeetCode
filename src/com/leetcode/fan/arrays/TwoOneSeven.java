package com.leetcode.fan.arrays;

/**
 * Created by : PF
 * Date on : 2018/12/18.
 */

public class TwoOneSeven {
    public boolean containsDuplicate(int[] nums) {
        // 之前有遇到过这种
        for(int i = 0;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if (nums[i] > nums[j])
                    break;
                else if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1};
        boolean result = new TwoOneSeven().containsDuplicate(nums);
        System.out.println(result);
    }
}

