package com.leetcode.fan.sort;

/**
 * Created by : PF
 * Date on : 2019-07-07.
 */

public class HeapSort {
    /**
     * 堆排序
     */
    private static void heapSort(int[] arr) {
        // 将待排序的序列构建成一个大顶堆
        for (int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }

        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i); // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            heapAdjust(arr, 0, i); // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
        }
    }

    private static void swap(int[] arr, int k, int j) {
        int temp = arr[k];
        arr[k] = arr[j];
        arr[j] = temp;
    }

    /**
     * 构建大顶堆的过程
     *
     * @param arr 需要排序的数组
     * @param i   需要构建堆的根节点的序号
     * @param n   数组的长度
     */
    private static void heapAdjust(int[] arr, int i, int n) {
        int child;
        int father;
        for (father = arr[i]; arr[i << 1 + 1] < n; i = child) { // arr[i << 1 + 1] : 左孩子节点
            child = arr[i << 1 + 1];

            // 如果左子树小于右子树，则需要比较右子树和父节点
            if (child != n - 1 && arr[child] < arr[child + 1]) {
                child++; // 序号增1，指向右子树
            }

            // 如果父节点小于孩子结点，则需要交换
            if (father < arr[child]) {
                arr[i] = arr[child];
            } else {
                break; // 大顶堆结构未被破坏，不需要调整
            }
        }
        arr[i] = father;
    }

    public static void main(String[] args) {
        int[] tree = {2, 5, 3, 1, 10, 4, 6};
//        int n = 7;
        heapSort(tree);
//        buildHeap(tree, n);
        for (int i = 0; i < tree.length - 1; i++) {
            System.out.println(tree[i]);
        }
    }

//    private static void heapify(int[] tree, int n, int i) {
//        if (i >= n)
//            return;
//
//        int leChild = (i << 1) + 1;
//        int riChild = leChild + 1;
//        int max = i;
//        if (leChild < n && (tree[leChild] > tree[max]))
////            max = leChild;
//            swap(tree, max, leChild);
//
//        if (riChild < n && tree[riChild] > tree[max])
////            max = riChild;
//            swap(tree, max, riChild);
//        if (max != i)
//            swap(tree, max, i);
//            heapify(tree, n ,max);
//    }

    /**
     * 建立堆
     * @param tree 待建立的堆对应的数组
     * @param n 堆个数
     */
//    private static void buildHeap(int[] tree, int n) {
//        int lastNode = n - 1;
//        int parentNode = (lastNode - 1) >> 1;
//        int i;
//        for (i = parentNode; i >= 0; i--) {
//            heapify(tree, n, i);
//        }
//    }

//    private static void heapSort(int[] tree, int n) {
//        buildHeap(tree, n);
//        int i;
//        for (i = n - 1; i >= 0; i--) {
//            swap(tree, i, 0);
//            heapify(tree, i, 0); // i : 当前树的数量
//        }
//
//    }

}

