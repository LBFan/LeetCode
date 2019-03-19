package com.leetcode.fan.DP;

/**
 * Created by : PF
 * Date on : 2018/12/21.
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */

public class Five {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (s == null || len == 0) {
            return s;
        }
        String res = "";
        int max = 0;
        // 创建一个行列均为字符串长度的二维数组，创建时默认初始化为false
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                // 这里只考虑了i<=j的情况，因为i>j时均为false
                // 当i==j,j-i==1,j-i==2时，只要满足s.charAt(i) == s.charAt(j)就是回文字符串
                // 如果不是这样，还要判断当前回文字符串的子串是不是回文字符串，即dp[i + 1][j - 1])，这就是动
                // 态规划思想
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {// 如果是回文字符串
                    if (j - i + 1 > max) {// 并且比之前的回文字符串要长，更新字符串长度，记录字符串
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "babad";
        String result = new Five().longestPalindrome(s);
        System.out.println(result);
    }
}

