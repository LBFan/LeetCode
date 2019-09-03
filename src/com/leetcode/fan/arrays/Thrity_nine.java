package com.leetcode.fan.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by : PF
 * Date on : 2018/10/31.
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */

public class Thrity_nine {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrace(res,list,candidates,target,target,0);
        return res;
    }
    public void backTrace(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int remain, int start){
        if(remain < 0)
            return;
        if(remain == 0){
            res.add(new ArrayList<>(list));
        }else{
            for(int i=start;i<nums.length;i++){
                list.add(nums[i]);
                backTrace(res,list,nums,target,remain-nums[i],i);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;

        List<List<Integer>> result = new Thrity_nine().combinationSum(candidates, target);
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

