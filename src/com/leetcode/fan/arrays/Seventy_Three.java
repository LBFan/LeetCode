package com.leetcode.fan.arrays;

/**
 * Created by : PF
 * Date on : 2018/11/15.
 */

public class Seventy_Three {
    public void setZeroes(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        // 从左上到右下进行遍历
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0)  {// 用第一列来标记为零的位置
                col0 = 0;
            }
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // 从右下到左上进行遍历
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) matrix[i][0] = 0; // 用第一行来标记为零的位置
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,0,1,0},{1,1,1,1,1},{0,1,1,1,1},{0,1,1,1,1},{1,1,1,1,1}};
        new Seventy_Three().setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }
}

