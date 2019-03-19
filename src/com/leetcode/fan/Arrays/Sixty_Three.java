package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2018/11/12.
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * 输入:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出: 2
 * <p>
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */

public class Sixty_Three {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 使用动态规划的算法思想进行求解

        // case1: 数组为空
        if (obstacleGrid == null || obstacleGrid.length == 0
                || obstacleGrid[0].length == 0) {
            return 0;
        }

        // 数组首（左上）或者尾（右下）不为0
        if (obstacleGrid[0][0] != 0
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] != 0) {
            return 0;
        }

        // 正常情况
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;

        //将第一行中1后面的0全部置为1
        for (int j = 1; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 0 && dp[0][j - 1] == 1)
                dp[0][j] = 1;
        }

        // 将第一列中1后面的0全部置为1
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1)
                dp[i][0] = 1;
        }

        // 利用动态规划求和
        for (int i = 1;i < obstacleGrid.length;i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int result = new Sixty_Three().uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
    }
}

