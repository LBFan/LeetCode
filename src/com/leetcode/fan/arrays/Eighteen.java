package com.leetcode.fan.arrays;

import java.util.*;

/**
 * Created by : PF
 * Date on : 2018/10/30.
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */

public class Eighteen {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<4){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                //nums[i] is too large
                break;
            }
            if(nums[i] + nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3] < target){
                //nums[i] is too small
                continue;
            }
            if(i>0 && nums[i]==nums[i-1]){  //跳过重复项
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2] > target){   //nums[j] is too large
                    break;
                }
                if(nums[i]+nums[j]+nums[nums.length-1] + nums[nums.length-2] < target){
                    // nums[j] is too small
                    continue;
                }
                if(j>i+1 && nums[j]==nums[j-1]){    //跳过重复项
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = new Eighteen().fourSum(nums,target);
        // 双重循环遍历
        for (List<Integer> resultList:
             result) {
            for (Integer res:
                    resultList) {
                System.out.print(res + " ");
            }
            System.out.println();

        }

    }
}

