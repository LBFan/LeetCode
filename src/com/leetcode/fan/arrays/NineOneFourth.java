package com.leetcode.fan.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/23.
 */

public class NineOneFourth {
    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }
        // 计数 有不一样个数时，返回false，否则返回true
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : deck) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int minSize = Integer.MAX_VALUE;
        for(int i : map.values()) {
            minSize = Math.min(minSize, i);
        }
        int res = 0;
        for(int x : map.values()) {
            res = mcd(x, res);
        }
        return res > 1;
    }
    // 辗转相除求最大公约数
    public static int mcd(int a, int b) {
        if (b > a) {
            return mcd(b, a);
        }
        return b > 0 ? mcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        int[] deck = {1, 1, 2, 2, 3, 3, 3};
        boolean b = hasGroupsSizeX(deck);
        System.out.println(b);
    }
}

