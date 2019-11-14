package com.leetcode.fan;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/11/06.
 */

public class Num09 {
    public static boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        }
//        char[] arr = String.valueOf(x).toCharArray();
//        int lo = 0, hi = arr.length - 1;
//        while (lo < hi) {
//            if (arr[lo++] != arr[hi--]) {
//                return false;
//            }
//        }
//        return true;

        // 方法2：正常思维：比较两个数是否相等
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int y = x;
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result == y;
    }

    public static void main(String[] args) {
        int x = 121;
        int y = -121;
        int z = 123;
        boolean palindrome = isPalindrome(x);
        boolean palindrome1 = isPalindrome(y);
        boolean palindrome2 = isPalindrome(z);

        System.out.println(palindrome);
        System.out.println(palindrome1);
        System.out.println(palindrome2);
    }
}

