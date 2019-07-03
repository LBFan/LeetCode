package com.leetcode.fan.newfeture;

import java.util.Arrays;
import java.util.List;

/**
 * Created by : PF
 * Date on : 2019-06-26.
 */

public class LambdaTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(System.out::println);
    }
}

