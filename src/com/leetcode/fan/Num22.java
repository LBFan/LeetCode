package com.leetcode.fan;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/11/14.
 */

public class Num22 {
    public static List<String> generateParenthesis(int n) {
        if (n < 1) return Collections.emptyList();
        if (n == 1) return Collections.singletonList("()");

        List<String> res = new ArrayList<>();
        // recursion
        generate(1, n, res, "("); // 必是'('
        return res;
    }

    private static void generate(int leftCnt, int max, List<String> res, @NotNull String curr) {
        // terminal
        // 总长已满，已到状态树最底层(叶子结点)
        if (curr.length() >= max * 2) {
            res.add(curr);
            return;
        }

        // process
        // drill down
        // 左括号个数受限
        if (leftCnt < max) {
            generate(leftCnt + 1, max, res, curr + "(");
        }

        // 右括号个数 = 当前字符长度 - 左括号个数
        // rightCnt = curr.length() - leftCnt
        // rightCnt < leftCnt
        // 右比左少，必在受限max之内
        if (curr.length() < leftCnt * 2) {
            generate(leftCnt, max, res, curr + ")");
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<String> strings = generateParenthesis(n);
        System.out.println(strings.toString());
    }
}

