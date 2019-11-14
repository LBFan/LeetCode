package com.leetcode.fan.search;

/**
 * @author :  PF_23
 * @Description : 五种
 * ①基本查找
 * ②查找第一个值等于给定值的元素
 * ③查找最后一个值等于给值得元素
 * ④查找第一个大于等于给定值的元素
 * ⑤查找最后一个小于等于给定值得元素
 * @date : 2019/10/15.
 */

public class BinarySearch {

    /**
     * 基本查找
     *
     * @param arr    给定数组
     * @param target 目标值
     * @return 目标元素的下标
     */
    private static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (arr[mid] > target) {
                hi = mid - 1;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 查找第一个值等于给定值的元素(数组中元素有重复)
     *
     * @param arr    给定数组
     * @param target 目标值
     * @return 目标元素的下标
     */
    private static int findFirst(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (arr[mid] > target) {
                hi = mid - 1;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != target) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素(数组中元素有重复)
     *
     * @param arr    给定数组
     * @param target 目标值
     * @return 目标元素的下标
     */
    private static int findLast(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (arr[mid] > target) {
                hi = mid - 1;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != target) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值得元素(数组中元素有重复)
     *
     * @param arr    给定数组
     * @param target 目标值
     * @return 目标元素的下标
     */
    private static int findFirstThan(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (arr[mid] >= target) {
                if (mid == 0 || arr[mid - 1] < target) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    private static int findLastLess(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (arr[mid] <= target) {
                if (mid == arr.length - 1 || arr[mid + 1] > target) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 6, 8, 10};
        int target = 6;
        int i = binarySearch(arr1, target);
        System.out.println("the " + i + "th element is " + target);

        int[] arr2 = {1, 2, 6, 6, 8, 10};
        int first = findFirst(arr2, target);
        int last = findLast(arr2, target);
        System.out.println("the " + first + "th element is the first " + target);

        System.out.println("the " + last + "th element is the last " + target);

        int key = 5;
        int firstThan = findFirstThan(arr1, key);
        System.out.println("the " + firstThan + "th element is the first element than " + target);
        int lastLess = findLastLess(arr1, key);
        System.out.println("the " + lastLess + "th element is the last element less than " + target);
    }
}

