package com.platform.data_structure.sort;

/**
 * @Title: BubbleSort
 * @Description: 归并排序，时间复杂度O(N*LogN)，额外空间复杂度O(N)
 * 算法说明：
 * 1、将原数组分成两个相对（近似相等）的子数组，位置：0~mid，mid~n-1
 * 2、对子数组进行排序
 * 3、对排好序的两个子数组，使用外排序O(N)的方式合并
 *
 * 核心思想：利用有序的特性，把小的有序，合并成大的有序。是每一次比较均有效
 *
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/8/25 14:51
 */
public class MergeSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
