package com.leetcode.fan.sort;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/12.
 */

public class MergeSort {
    private static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (end <= start) return;
        int mid = (start + end) >>> 1; //划分子序列
        mergeSort(arr, start, mid); //对左侧子序列进行递归排序
        mergeSort(arr, mid + 1, end); //对右侧子序列进行递归排序
        merge(arr, start, mid, end); //合并
    }

    //两路归并算法，两个排好序的子序列合并为一个子序列
    private static void merge(int[] arr, int le, int mid, int ri) {
        int[] tmp = new int[arr.length]; //辅助数组
        // method01
//        int i = le;
//        int j = mid + 1;
//        for (int k = start; k <= end; k++) {
//            tmp[k] = arr[k];
//        }
//        for (int k = start; k <= end; k++) {
//            if (i > mid) {
//                arr[k] = tmp[j++];
//            } else if (j > end) {
//                arr[k] = tmp[i++];
//            } else if (tmp[j] < tmp[i]) {
//                arr[k] = tmp[j++];
//            } else {
//                arr[k] = tmp[i++];
//            }
//        }
        // method02
        int p1 = le, p2 = mid + 1, k = le;//p1、p2是检测指针，k是存放指针
        while (p1 <= mid && p2 <= ri) {
            if (arr[p1] <= arr[p2]) {
                tmp[k++] = arr[p1++];
            } else {
                tmp[k++] = arr[p2++];
            }
        }
        while (p1 <= mid) tmp[k++] = arr[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p2 <= ri) tmp[k++] = arr[p2++];//同上

        //复制回原素组
        for (int i = le; i <= ri; ++i) {
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 4, 8, 6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

