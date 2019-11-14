package com.leetcode.fan.search;

/**
 * @author :  PF_23
 * @Description : 八皇后问题
 * @date : 2019/10/25.
 */

public class EightQueen {

    static int count = 0;
    static int[] result = new int[8];// 下标表示行，值表示queen存储在哪一列

    private static void cal8queens(int row) { // 调用时：cal8queens(0);
        if (row == 8) { // 8个棋子都放置好了，打印结果
            printQueens(result);
            count++;
            return; // 打印完成之后返回了，没有可以递归的了
        }
        for (int cal = 0; cal < 8; cal++) {  // 每一行都有8种放法
            if (isOk(row, cal)) { // 放法满足要求
                result[row] = cal; // 第row行的棋子放到cal列
                cal8queens(row + 1); // 考察下一行
            }
        }
    }

    private static boolean isOk(int row, int cal) {
        int leftUp = cal - 1, rightUp = cal + 1;
        for (int i = row - 1; i >= 0; i--) { // 逐行往上考察每一行
            if (result[i] == cal) {
                return false; // 第i行的column列有棋子
            }
            if (leftUp >= 0) { // 考察左上对角线:第i行leftup列有棋子吗?
                if (result[i] == leftUp) {
                    return false;
                }
            }
            if (rightUp < 8) {  // 考察右上对角线:第i行rightup列有棋子吗?
                if (result[i] == rightUp) {
                    return false;
                }
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    private static void printQueens(int[] result) {
        for (int row = 0; row < 8; ++row) {
            for (int cal = 0; cal < 8; cal++) {
                if (result[row] == cal) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        cal8queens(0);
        System.out.println("-----------------------------------");
        System.out.println(count);
    }
}

