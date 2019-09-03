package com.leetcode.fan.arrays;

import java.util.HashMap;

class FiveThreeTwo {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        if (k < 0)
            return count;
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i] + k) && hm.get(nums[i]+k) != i){
                count++;
                hm.remove(nums[i] + k);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,4,5};
        int k = 2;
        int result = new FiveThreeTwo().findPairs(nums, k);
        System.out.println(result);
    }
}