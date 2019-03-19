package com.leetcode.fan.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by : PF
 * Date on : 2018/11/18.
 * <p>
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */

public class Ninty {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int n :
                nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                if (!(result.contains(subset) || subset.stream().distinct().count() == 1)) {
                    result.add(subset);
                }
            }
        }
        return result;
        /**
         *
         4
         4 4
         4 4 4
         1
         4 1
         4 4 1
         4 4 4 1
         4 4 4 4
         1 4
         4 1 4
         4 4 1 4
         4 4 4 1 4
         */
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> result = new Ninty().subsetsWithDup(nums);
        for (List<Integer> res :
                result) {
            for (Integer node :
                    res) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}

