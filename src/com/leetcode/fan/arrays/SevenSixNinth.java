package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/11.
 */

public class SevenSixNinth {
    public static int maxChunksToSorted(int[] arr) {
        //
//        if(arr ==null){
//            return 0;
//        }
//
//        int ret = 0;
//        int max =arr[0];
//        for(int i=0;i< arr.length;i++){
//            max = Math.max(max,arr[i]);
//            if(max==i){
//                ret++;
//            }
//        }
//        return ret;
        int[] max = new int[arr.length];
        max[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max[i] = Math.max(arr[i], max[i - 1]);
        }
        int cmin = Integer.MAX_VALUE, re = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            // 确切地说，cmin记录的是arr[i+1]到最后一个数之间的最小值
            // 如果cmin >= max[i], 则i这里就是一个分割点
            if (cmin >= max[i]) {
                re++;
            }
            cmin = Math.min(cmin, arr[i]);
        }
        return re;
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,4,5};
        int ret = maxChunksToSorted(arr);
        System.out.println(ret);
    }
}

