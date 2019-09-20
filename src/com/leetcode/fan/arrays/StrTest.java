package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/19.
 */

public class StrTest {
    public static void main(String[] args) {
        String str = "hello pp i lv y";
        StringBuffer s = new StringBuffer(str);
        String replaceSpace = replaceSpace(s);
        System.out.println(replaceSpace);

    }

    private static String replaceSpace(StringBuffer str) {
        int p1 = str.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("   ");
            }
        }

        int p2 = str.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }
}

