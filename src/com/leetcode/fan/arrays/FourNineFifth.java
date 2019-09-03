package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description : 思路：
 * 计算最后一位中毒结束时间lastEnd，lastEnd = timeSeries[timeSeries.length - 1] + duration - timeSeries[0];
 * 总时间 = lastEnd-count
 * @date : 2019/09/03.
 */

public class FourNineFifth {
    private static int findPoisonedDuration(int[] timeSeries, int duration) {
//        int i = 0;//遍历用指针
//        int sum = 0;//计算中间未中毒时间长度
//
//        int length = timeSeries.length;
//        int timeLength = timeSeries[length - 1] + duration;
//        int temp;
//
//        if (length == 0)
//            return 0;
//
//        while (i < length) {
//            if (i >= 1)
//                temp = timeSeries[i - 1] + duration;
//            else
//                temp = 0;
//
//            if (timeSeries[i] > temp)
//                sum += timeSeries[i] - temp;
//            i++;
//        }
//
//        return timeLength - sum;
        if (timeSeries.length == 0)
            return 0;

        int sum = 0;

        int start = timeSeries[0];
        int end = start + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (end < timeSeries[i]) {// 非连续中毒
                sum += end - start;
                start = timeSeries[i];
                end = start + duration;
            } else {// 连续中毒
                end = timeSeries[i] + duration;
            }
        }
        return sum + end - start;
    }

    public static void main(String[] args) {
        int[] timeSeries = {1, 5, 7};
        int duration = 3;
        int time = findPoisonedDuration(timeSeries, duration);
        System.out.println(time);
    }
}

