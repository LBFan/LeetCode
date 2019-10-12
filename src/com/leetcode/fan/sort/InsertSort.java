package com.leetcode.fan.sort;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/12.
 */

public class InsertSort {
    private static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // form i = 1 ~ n - 1 (第二个数到最后一个数）
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int end = i - 1;// 已经排序好的序列的最后一个数
            // 插入array[i] 到已序序列中 array[0.. i-1]
            while (end >= 0 && temp < arr[end]) {
                arr[end + 1] = arr[end];
                end--;
            }
            // 插入 array[i]
            arr[end + 1] = temp;
        }
    }

    private static void binaryInsertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 1; i < arr.length; ++i) {
            int tmp = arr[i];
            int le = 0, ri = i - 1; // 有序序列的左右边界
            while (le <= ri) {
                int mid = (le + ri) >> 1;
                // 注意这里的 等号，为了保证算法的稳定性（相同关键字排序前后位置不会变）
                // 所以也需要向后移动
                if (arr[mid] <= tmp) {
                    le = mid + 1;
                } else if (arr[mid] > tmp) {
                    ri = mid - 1;
                }
            }
            // 搬移数据， 上面循环结束后，left的位置就是插入位置
            // 需要将从left 到 当前插入元素的前一个位置都搬移一个位置
            for (int j = i - 1; j >= le; j--) {
                arr[j + 1] = arr[j];
            }
            arr[le] = tmp;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] arr = {4, 5, 6, 7, 8, 9, 0, -1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 6, 7, 8};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        binaryInsertSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("insertSort spend time:" + (System.currentTimeMillis() - start));
        System.out.println("binaryInsertSort spend time:" + (System.currentTimeMillis() - start));
    }
}

