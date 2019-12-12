package com.leetcode.fan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  PF_23
 * @Description : 判断有效的数独
 * @date : 2019/11/27.
 */

public class Num36 {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] columns = new HashMap[9];
        Map<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; ++i) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; j++) {
                char n = board[i][j];
                if (n != '.') {
                    int num = (int) n;
                    int box_index = (i / 3) * 3 + j / 3;

                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    columns[j].put(num, columns[j].getOrDefault(num, 0) + 1);
                    boxes[box_index].put(num, boxes[box_index].getOrDefault(num, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(num) > 1 || columns[j].get(num) > 1 || boxes[box_index].get(num) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

