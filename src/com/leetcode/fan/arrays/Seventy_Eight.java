package com.leetcode.fan.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by : PF
 * Date on : 2018/11/14.
 * <p>
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * 总结：一共2的n次方个子集
 */

public class Seventy_Eight {

    // 回溯法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result  = new ArrayList<>(); // 创建结果集
        Arrays.sort(nums);
        backtrace(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrace(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrace(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();  // 创建结果数组
//        result.add(new ArrayList<>()); // 将空数组添加到结果数组中
//        for(int n : nums){
//            int size = result.size();
//            for(int i=0; i<size; i++){
//                List<Integer> subset = new ArrayList<>(result.get(i));
//                subset.add(n);
//                result.add(subset);
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        int[] nums = {4,2,3};
        List<List<Integer>> result = new Seventy_Eight().subsets(nums);
        System.out.println("[");
        for (List<Integer> res:
             result) {
            for (Integer re:
                 res) {
                System.out.print(re + " ");
            }
            System.out.println();
        }
        System.out.println("]");
    }
}

