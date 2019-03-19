package com.leetcode.fan.Arrays;

/**
 * Created by : PF
 * Date on : 2018/11/7.
 * <p>
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * 输入: 3
 * <p>
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */

public class Fifty_Nine {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        if (n < 1) {
            return result;
        }

        int top = 0, right = n - 1, buttom = n - 1, left = 0;
        int i = 1;
        int size = n * n;

        while (size > 0) {
            // from left to right
            for (int col = left; col <= right; col++) {
                result[top][col] = i;
                size--;
                i++;
            }
            top++;

            // from top to buttom
            if (size > 0) {
                for (int row = top; row <= buttom; row++) {
                    result[row][right] = i;
                    size--;
                    i++;
                }
                right--;
            }

            // from right to left
            if (size > 0) {
                for (int row = right; row >= left; row--) {
                    result[buttom][row] = i;
                    size--;
                    i++;
                }
                buttom--;
            }

            // from buttom to top
            if (size > 0) {
                for (int col = buttom; col >= top; col--) {
                    result[col][left] = i;
                    size--;
                    i++;
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] result = new Fifty_Nine().generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

