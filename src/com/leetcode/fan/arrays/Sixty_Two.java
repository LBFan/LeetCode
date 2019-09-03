package com.leetcode.fan.arrays;

/**
 * Created by : PF
 * Date on : 2018/11/9.
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 */

public class Sixty_Two {
    public int uniquePaths(int m, int n) {
        //使用排列组合的方法求解
        double bottom = 1;
        double top = 1;
        // 始终让 m > n
        int hi = m > n ? m - 1 : n - 1;
        int lo = m > n ? n - 1 : m - 1;

        for (int i = 1; i <= lo; i++) {
            bottom *= i;
            top *= lo + hi - i + 1;
        }
        return (int) (top / bottom);
    }

    public static void main(String[] args) {
        int m = 3, n = 2;
        int result = new Sixty_Two().uniquePaths(m, n);
        System.out.println(result);
    }
}

