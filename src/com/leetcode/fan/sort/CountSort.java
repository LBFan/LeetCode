package com.leetcode.fan.sort;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 计数排序
 * @date : 2019/10/14.
 */

public class CountSort {
    private static void countSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;
        int max = arr[0];
        // 1. 统计数组范围 i~j,新建额外数组c[j - 1 + 1]
        for (int item : arr) {
            if (max < item) {
                max = item;
            }
        }
        // 2. 统计每个元素出现的次数
        int[] c = new int[max + 1]; // 申请一个计数数组c,下标大小[0,max]
//        for (int i = 0; i <= max; ++i) {
//            c[i] = 0;
//        }
        for (int value : arr) {
            c[value]++;
        }
        // 3. 按照元素从小到大的顺序将次数累加,放入到c[i]中
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i - 1] + c[i];
        }
        // 4. 新建临时数组r,存储排序之后的结果
        int[] r = new int[n];
        for (int j = n - 1; j >= 0; --j) {
            int index = c[arr[j]] - 1;
            r[index] = arr[j];
            c[arr[j]]--;
        }
        // 4. 将结果拷贝给arr数组
        System.arraycopy(r, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

