package com.leetcode.fan.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by : PF
 * Date on : 2018/12/5.
 * <p>
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */

public class OneTwoEight {

    public int longestConsecutive(int[] nums) {
        //可以采用哈希表来做，刚开始哈希表为空，然后遍历所有数字，如果该数字不在哈希表中，
        // 那么我们分别看其左右两个数字是否在哈希表中，如果在，则返回其哈希表中映射值，若不在，则返回0，
        // 然后我们将left+right+1作为当前数字的映射，并更新res结果，然后更新d-left和d-right的映射值
        int res = 0;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (m.containsKey(num)) continue; // 去重
            int left = m.containsKey(num - 1) ? m.get(num - 1) : 0;
            int right = m.containsKey(num + 1) ? m.get(num + 1) : 0;
            int sum = left + right + 1;
            m.put(num, sum);
            res = Math.max(res, sum);
            m.put(num - left, sum);
            m.put(num + right, sum);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,-1};
        int maxLen = new OneTwoEight().longestConsecutive(nums);
        System.out.println(maxLen);
    }
}

// 1.本测试一共由7个部分组成：
//
//I. Listening A （6 min）：短对话9题
//
//II. Listening B (9 min)：短文两篇共6题
//
//III. Listening C (10 min)：讲座一篇共5题
//
//IV. Vocabulary & Structure A (5 min)：10题
//
//V. Vocabulary & Structure B (5 min)：10题
//
//VI. Cloze (10 min)：10题
//
//VII. Reading (45 min)：5篇文章，每篇文章6个问题，共30题。
//
//2. 第1~20题为听力，音频自动播放，根据所听内容回答问题，请提前戴好耳机并调节音量。
//
//3. 本测试时长共90分钟，点击“开始测试”90分钟后测试将自动结束，网页将自动关闭。网页右上角时钟会显示测试剩余时间。测试对速度有一定要求，同学们可参考各部分时间限制，合理分配答题时间。

