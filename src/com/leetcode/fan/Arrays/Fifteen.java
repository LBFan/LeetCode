package com.leetcode.fan.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

class Fifteen {
    public static void main(String[] args) {
        int[] num = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(num);
        for (List res:result
             ) {
            System.out.println(res);
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  result = new ArrayList<>();
        if(nums == null || nums.length < 3)
            return result;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                ArrayList<Integer> path = new ArrayList<Integer>();
                if(sum == 0){
                    path.add(nums[i]);
                    path.add(nums[left]);
                    path.add(nums[right]);
                    if(result.contains(path)==false)
                        result.add(path);
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}