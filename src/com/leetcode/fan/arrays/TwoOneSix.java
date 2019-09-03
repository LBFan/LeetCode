package com.leetcode.fan.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by : PF
 * Date on : 2018/12/18.
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */

public class TwoOneSix {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,n,k,0,new ArrayList<>(),0);
        return res;
    }
    //     深度搜索+剪枝
    public boolean dfs(List<List<Integer>> res,int n,int k,int value,List<Integer> nums,int sum){
        if(sum>n || nums.size()>k) {
            return false;
        }
        if(sum==n && nums.size()==k) {
            List<Integer> temp=new ArrayList<>();
            temp.addAll(nums);
            res.add(temp);
            return true;
        }
        for(int i=value+1;i<10;i++){
            nums.add(i);
            boolean b=dfs(res,n,k,i,nums,sum+i);
            // 回溯
            nums.remove(nums.size()-1);
            if(!b) break;
        }
        return true;
    }

    public static void main(String[] args) {
        int k = 3, n = 9;
        List<List<Integer>> res = new TwoOneSix().combinationSum3(k, n);

        System.out.print("[");
        System.out.println();
        for (List<Integer> result :
                res) {
            System.out.print("[");
            for (Integer num :
                    result) {
                System.out.print(num + " ");
            }
            System.out.print("]");
            System.out.println();

        }
        System.out.print("]");
    }
}

