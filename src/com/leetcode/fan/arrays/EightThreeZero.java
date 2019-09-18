package com.leetcode.fan.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/16.
 */

public class EightThreeZero {
    public List<List<Integer>> largeGroupPositions(String S) {
        //双指针法
//        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < S.length() - 2; i++) {
//            List<Integer> tmp = new ArrayList<>();
//            if (S.charAt(i) == S.charAt(i + 2)) {
//                tmp.add(i);
//                for (int j = i + 2; j < S.length(); j++) {
//                    if (S.charAt(j) == S.charAt(j - 1)) {
//                        continue;
//                    } else {
//                        tmp.add(j - 1);
//                        list.add(tmp);
//                        break;
//                    }
//                }
//            }
//        }
//        return list;
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = S.length();
        for (int j = 0; j < N; j++) {
            if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
                // Here, [i, j] represents a group.
                if (j - i + 1 >= 3) {
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                }
                i = j + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

