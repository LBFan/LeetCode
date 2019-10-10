package com.leetcode.fan.arrays;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/08.
 */

public class HelloDate {
    public static void main(String[] args) {
        System.out.println("hello, it's: ");
        System.out.println(new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date()));
    }
}

