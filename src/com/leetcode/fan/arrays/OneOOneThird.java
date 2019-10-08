package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/30.
 */

public class OneOOneThird {
    public static boolean canThreePartsEqualSum(int[] A) {
        boolean flag = false;
        int len = A.length;
        if (len < 3) {
            return false;
        }
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int per = sum / 3;
        int i = 0;
        int perSum = 0;
        for (; i < len - 2; ++i) {
            perSum += A[i];
            if (perSum == per) {
//                flag = true;
                break;
            }
        }
        i++;
        perSum = 0;
        for (; i < len - 1; ++i) {
            perSum += A[i];
            if (perSum == per) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr = {18, 12, -18, 18, -19, -1, 10, 10}; // {0,2,1,-6,6,7,9,-1,2,0,1},{3,3,6,5,-2,2,5,1,-9,4},{0,2,1,-6,6,-7,9,1,2,0,1}
        boolean b = canThreePartsEqualSum(arr);
        System.out.println(b);
    }
}

