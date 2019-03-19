package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2018/11/3.
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 */

public class Fourty_Five {
    public int jump(int[] nums) {
        // 本题用贪心法求解，
        // 贪心策略是在每一步可走步长内，走最大前进的步数
        if (nums.length <= 1) {
            return 0;
        }
        int index, max = 0;
        int step = 0, i = 0;
        while (i < nums.length) {
            //如果能直接一步走到最后，直接步数+1结束
            if (i + nums[i] >= nums.length - 1) {
                step++;
                break;
            }
            max = 0;//每次都要初始化
            index = i + 1;//记录索引，最少前进1步
            for (int j = i + 1; j - i <= nums[i]; j++) {//搜索最大步长内行走最远的那步
                if (max < nums[j] + j - i) {
                    max = nums[j] + j - i;//记录最大值
                    index = j;//记录最大值索引
                }
            }
            i = index;//直接走到能走最远的那步
            step++;//步长+1
        }
        return step;

//        int reachable = 0;
//        int next = 0;
//        int jump = 0;
//        for (int i = 0; i < nums.length; i++){
//            if (reachable < i){
//                jump++;
//                reachable = next;//如果不能到达，证明需要多跳一步，reachable就更新为前一个节点能到达的最远位置
//            }
//            next = Math.max(next,i+nums[i]);//当前i节点最远能reach的位置
//        }
//        return jump;

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int steps = new Fourty_Five().jump(nums);
        System.out.println(steps);
    }

}

