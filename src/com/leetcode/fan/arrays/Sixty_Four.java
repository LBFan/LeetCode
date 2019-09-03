package com.leetcode.fan.arrays;

/**
 * Created by : PF
 * Date on : 2018/11/13.
 */

public class Sixty_Four {
    public int minPathSum(int[][] grid) {
        // methods one : dynamic process (or can create another array arr[][])
        // int[][] arr = new int[grid.length][grid[0].length];
        for (int i = 1; i < grid.length; i++){
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < grid[0].length; j++){
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int minDis = new Sixty_Four().minPathSum(grid);
        System.out.println(minDis);
    }
}

