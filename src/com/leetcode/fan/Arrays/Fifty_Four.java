package com.leetcode.fan.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by : PF
 * Date on : 2018/11/5.
 * <p>
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class Fifty_Four {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;
        int rowNum = matrix.length, colNum = matrix[0].length;
        int top = 0, right = colNum - 1, bottom = rowNum - 1, left = 0;

        while (result.size() < rowNum * colNum) {
            // from left to right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // from top to buttom
            if (result.size() < rowNum * colNum) {
                for (int row = top; row <= bottom; row++) {
                    result.add(matrix[row][right]);
                }
                right--;
            }

            // from right to left
            if (result.size() < rowNum * colNum) {
                for (int row = right; row >= left; row--) {
                    result.add(matrix[bottom][row]);
                }
                bottom--;
            }

            // from buttom to top
            if (result.size() < rowNum * colNum) {
                for (int col = bottom; col >= top; col--) {
                    result.add(matrix[col][left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<Integer> result = new Fifty_Four().spiralOrder(matrix);
        for (Integer index :
                result) {
            System.out.print(index + " ");
        }
        System.out.println();
    }

}

