package com.leetcode.fan.n_queen;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/03.
 */

public class FiveSecond {
    static int count = 0;

    public static int totalNQueens(int n) {
        int row = 0, col = 0, pie = 0, na = 0;
        int res = DFS(n, row, col, pie, na);
        return res;
    }


    private static int DFS(int n, int row, int col, int pie, int na) {
        if (row >= n) {
            count++;
        }
        // 得到空位
        int bits = (~(col | pie | na)) & ((1 << n) - 1);
        while (bits > 0) {
            int p = bits & -bits; // 得到最后的1个空bit： -bit在计算机中是补码表示，即取反再+1
            DFS(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            // 去掉最后的1bit
            bits &= (bits - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 8;
        int res = totalNQueens(n);
        System.out.println(res);
    }
}

