package com.leetcode.fan.arrays;

import java.util.Stack;

import static java.lang.Math.max;

/**
 * Created by : PF
 * Date on : 2018/11/16.
 */

public class Eighty_Four {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int maxSize = 0;
        int i = 0;
        for (; i < heights.length; i++) {
            if (stack.empty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                // 当前遍历元素heights[i] 比栈顶元素tp对应的heights[tp]小, 栈顶元素出栈
                int tp = stack.pop();
                int beginIndex = stack.empty() ? -1 : stack.peek(); // 当栈为空时，说明最大矩形的长度从下标0开始
                // 所以将beginIndex设置为-1
                maxSize = max(maxSize, heights[tp] * (i - 1 - beginIndex));
                i--; // 由于heights[i]元素还在栈外等候，还需要继续和栈顶元素进行比较，所以i--
            }
        }

        while (!stack.empty()) {
            // 栈还不为空，对每个栈顶元素tp 计算以heights[tp]为高的矩形的最大面积, 并将栈顶元素出栈
            int tp = stack.pop();
            int beginIndex = stack.empty() ? -1 : stack.peek(); // 当栈为空时，说明最大矩形的长度从下标0到下标n-1，
            // 所以将beginIndex设置为-1
            maxSize = max(maxSize, heights[tp] * (i - 1 - beginIndex));
        }

        return maxSize;
    }

    private int max(int a, int b) {
        return a > b ? a : b;

    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        int maxArea = new Eighty_Four().largestRectangleArea(nums);
        System.out.println(maxArea);
    }
}