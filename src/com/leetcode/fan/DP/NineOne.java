package com.leetcode.fan.DP;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/10.
 */

public class NineOne {
    public static int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;

        if (s.charAt(0) == '0') return 0;

        int pre2 = 1;
        int pre1 = 1;
        int cur = 1;

        char p, q;
        for (int i = 2; i <= len; i++) {
            p = s.charAt(i - 2);
            q = s.charAt(i - 1);

            cur = 0;

            if (q != '0') cur = pre1;
            if (p == '1') cur += pre2;
            if (p == '2' && q <= '6') cur += pre2;

            if (cur == 0) return 0;

            pre2 = pre1;
            pre1 = cur;
        }

        return cur;
    }

    public static void main(String[] args) {
        int i = numDecodings("226");
        System.out.println(i);
    }
}

