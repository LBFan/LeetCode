package com.leetcode.fan.sort;

/**
 * Created by : PF
 * Date on : 2019-07-07.
 * 快速排序
 */

public class QuickSort {

    private static void quickSort(int[] a, int left, int right) {
        int i, j, t, base;
        if (left > right)
            return;
        base = a[left]; // base中存的就是基准数
        i = left;
        j = right;      // 设置两个哨兵
        while (i != j) {
            // 顺序很重要，要先从右边开始找
            while (a[j] >= base && i < j)
                j--;
            // 再找右边的
            while (a[i] <= base && i < j)
                i++;
            // 交换两个数在数组中的位置
            if (i < j) {
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        // 最终将基准数归位
        a[left] = a[i];
        a[i] = base;

        quickSort(a, left, i - 1);// 继续处理左边的，这里是一个递归的过程
        quickSort(a, i + 1, right);// 继续处理右边的 ，这里是一个递归的过程
    }

    public static void main(String[] args) {
        int[] a = {6, 2, 3, 8, 1, 9, 4, 5, 7};
        System.out.println("快速排序前：");
        for (int ele :
                a) {
            System.out.print(ele + " ");
        }
        System.out.println();
        quickSort(a, 0, a.length - 1);
        System.out.println("快速排序后:");
        for (int ele :
                a) {
            System.out.print(ele + " ");
        }
    }
}

