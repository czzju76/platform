package com.platform.data_structure.sort;

/**
 * @Title: Sort
 * @Description:
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/8/24 15:38
 */
public class Sort {
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
