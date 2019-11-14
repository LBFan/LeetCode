package com.leetcode.fan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/11/06.
 */

public class Num13 {
    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
//        map.put("I", 1);
//        map.put("IV", 4);
//        map.put("V", 5);
//        map.put("IX", 9);
//        map.put("X", 10);
//        map.put("XL", 40);
//        map.put("L", 50);
//        map.put("XC", 90);
//        map.put("C", 100);
//        map.put("CD", 400);
//        map.put("D", 500);
//        map.put("CM", 900);
//        map.put("M", 1000);
//
//        int ans = 0;
//        for (int i = 0; i < s.length(); ) {
//            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
//                ans += map.get(s.substring(i, i + 2));
//                i += 2;
//            } else {
//                ans += map.get(s.substring(i, i + 1));
//                i++;
//            }
//        }
//        return ans;
//
        // 方法2
        char[] c = s.toCharArray();
        int res = 0;
        for (int i = 0; i < c.length; i++) {
            char c1 = c[i];
            switch (c1) {
                case 'M':
                    res += 1000;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'C':
                    if (i + 1 < c.length) {
                        if (c[i + 1] == 'M') {
                            res += 900;
                            i++;
                            break;
                        } else if (c[i + 1] == 'D') {
                            res += 400;
                            i++;
                            break;
                        }
                    }
                    res += 100;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'X':
                    if (i < c.length - 1) {
                        if (c[i + 1] == 'C') {
                            res += 90;
                            i++;
                            break;
                        } else if (c[i + 1] == 'L') {
                            res += 40;
                            i++;
                            break;
                        }
                    }
                    res += 10;
                    break;
                case 'V':
                    res += 5;
                    break;
                default:
                    // I
                    if (i < c.length - 1) {
                        if (c[i + 1] == 'X') {
                            res += 9;
                            i++;
                            break;
                        } else if (c[i + 1] == 'V') {
                            res += 4;
                            i++;
                            break;
                        }
                    }
                    res += 1;
                    break;
            }
        }
        return res;
    }
}

