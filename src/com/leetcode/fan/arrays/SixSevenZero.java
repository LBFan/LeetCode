package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/06.
 */

public class SixSevenZero {
    public static int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] indices = new int[10];
        int result = num;
        for(int i = 0; i < digits.length; i++) {
            indices[digits[i] - '0'] = i;
        }
        for(int i = 0; i < digits.length-1; i++) {
            int digit = digits[i] - '0';
            for(int j = 9; j > digit; j--) {
                if(indices[j] > i) {
                    char temp = digits[i];
                    digits[i] = digits[indices[j]];
                    digits[indices[j]] = temp;
                    result = Integer.parseInt(new String(digits));
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 6856;
        int max = maximumSwap(num);
        System.out.println(max);
    }
}

