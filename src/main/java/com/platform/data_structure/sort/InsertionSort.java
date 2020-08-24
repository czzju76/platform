package com.platform.data_structure.sort;

/**
 * @Title: InsertionSort
 * @Description: 插入排序，时间复杂度O(N^2)，额外空间复杂度O(1)
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/8/24 17:53
 */
public class InsertionSort extends Sort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }
}
