package com.leetcode.fan.str;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/25.
 */

public class PatternTest {
//    private static String strUtil(String s) {
//        String regx = ""
//    }


    public static void main(String[] args) {
        String s = "徐嘉忆#23892791";
        String[] strArr = s.split("#");
        System.out.println(strArr[0].trim());
        System.out.println(strArr[1].trim());
    }
}

