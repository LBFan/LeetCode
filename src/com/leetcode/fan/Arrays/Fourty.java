package com.leetcode.fan.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by : PF
 * Date on : 2018/11/1.
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */

public class Fourty {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        // 此题必须先排序
        Arrays.sort(candidates);
        dfsCore(res, 0, 0, tmp, candidates, target);
        return res;

    }

    private void dfsCore(List<List<Integer>> res, int curIdx, int sum, List<Integer> tmp, int[] candidates, int target) {

        if (sum > target)
            return;
        if (sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        //i = curIdx往后走，避免重复
        for (int i = curIdx; i < candidates.length; i++) {
            // 如果此层，下一个数跟当前数相等，则直接跳过，
            if (i > curIdx && candidates[i] == candidates[i - 1])
                continue;
            // 剪枝，可以没有，目的为了优化，必须先排序
            if (target < candidates[i])
                return;
            sum += candidates[i];
            // 剪枝，可以没有，目的为了优化，必须先排序
            if (target < sum)
                return;
            tmp.add(candidates[i]);
            // 传入i+1
            dfsCore(res, i + 1, sum, tmp, candidates, target);
            tmp.remove(tmp.size() - 1);
            // 回溯
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,5,2,1,2};
        int target = 5;

        List<List<Integer>> res = new Fourty().combinationSum2(nums, target);
//        System.out.print("[");
        for (List<Integer> result :
                res) {
            for (Integer conbi:
                 result) {
                System.out.print(conbi + " ");

            }
            System.out.println();

        }
    }

}

