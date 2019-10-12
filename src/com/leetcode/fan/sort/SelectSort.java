package com.leetcode.fan.sort;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/12.
 */

public class SelectSort {
    private static void selectSort(int[] arr) {
        int i, j; // i:有序区的末尾位置； j:无序区的起始位置
        int min; // 无序区中最小元素位置
        for (i = 0; i < arr.length; i++) {
            min = i;
            // 找arr[i+1],...arr[n-1]之间的最小元素，赋给min位置
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 6, 5, 8, 7, 0, 1, 9};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

