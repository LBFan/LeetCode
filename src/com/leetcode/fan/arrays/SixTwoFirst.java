package com.leetcode.fan.arrays;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/05.
 */

public class SixTwoFirst {
    public static int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];

        for (char task :
                tasks) {
            c[task - 'A']++;
        }

        Arrays.sort(c);
        int index = 25;
        while (index >= 0 && c[25] == c[index]) {
            index--;
        }
        //存在最小值为数组长度的情况
        return Math.max((c[25] - 1) * (n + 1) + 25 - index, tasks.length);
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B','C','C','D'};
        int minLen = leastInterval(tasks, 2);
        System.out.println(minLen);
    }
}

