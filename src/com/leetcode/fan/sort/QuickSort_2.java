package com.leetcode.fan.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/12.
 */

public class QuickSort_2 {

    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * 递归排序
     *
     * @param src
     * @param begin
     * @param end
     */
    private static void quickSort(int[] src, int begin, int end) {
        if (begin < end) {
            int key = src[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && src[j] > key) {
                    j--;
                }
                if (i < j) {
                    src[i] = src[j];
                    i++;
                }
                while (i < j && src[i] < key) {
                    i++;
                }
                if (i < j) {
                    src[j] = src[i];
                    j--;
                }
            }
            src[i] = key;
            quickSort(src, begin, i - 1);
            quickSort(src, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,7,4,9,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
     }

}

