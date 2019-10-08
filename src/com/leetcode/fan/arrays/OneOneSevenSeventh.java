package com.leetcode.fan.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/08.
 */

public class OneOneSevenSeventh {
    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ret = new ArrayList<>();
        int[] bitSet = new int[s.length() + 1];
        int t = 0;
        for (int i = 0; i < s.length(); i++) {
            t ^= (1 << (s.charAt(i) - 'a'));
            bitSet[i + 1] = t;
        }

        for (int[] q : queries) {
            t = bitSet[q[0]] ^ bitSet[q[1] + 1];
            int tmp = Integer.bitCount(t);
            ret.add(tmp <= q[2] + q[2] + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "abcda";
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        List<Boolean> booleans = canMakePaliQueries(s, queries);

    }
}

