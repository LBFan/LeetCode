package com.leetcode.fan.sort;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/12.
 */

public class ShellSort {
    private static void shellSort(int[] arr) {
        int i, j, gap;
        int n = arr.length;

        for (gap = n / 2; gap > 0; gap /= 2) {
            for (i = gap; i < n; i++) {
                for (j = i - gap; j >= 0 && arr[j] > arr[j + gap]; j -= gap) {
                    int tmp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 7, 3, 6, 8, 9, 4, 0, 5};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

