package com.leetcode.fan.sort;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/11.
 * <p>
 * 优化思想：
 * 现在有一个包含1000个数的数组，仅前面100个无序，后面900个都已排好序且都大于前面100个数字，
 * 那么在第一趟遍历后，最后发生交换的位置必定小于100，且这个位置之后的数据必定已经有序了，
 * 也就是这个位置以后的数据不需要再排序了，于是记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。
 * 如果是对于上面的冒泡排序算法2来说，虽然也只排序100次，但是前面的100次排序每次都要对后面的900个数据进行比较，
 * 而对于现在的排序算法3，只需要有一次比较后面的900个数据，之后就会设置尾边界，保证后面的900个数据不再被排序。
 */

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int flag = arr.length; // flag用来记录最后交换发生的位置，也就是排序的尾边界
        int j, k;
        while (flag > 0) { // 排序未结束标志
            k = flag; // k来记录遍历的尾边界
            flag = 0;
            for (j = 1; j < k; j++) {
                if (arr[j - 1] > arr[j]) {//前面的数字大于后面的数字就交换
                    //交换a[j-1]和a[j]
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    //表示交换过数据;
                    flag = j;//记录最新的尾边界
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 4, 7, 6, 8, 9, 10};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

