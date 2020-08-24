package com.platform.data_structure.sort;

import java.util.Arrays;

/**
 * @Title: BubbleSort
 * @Description:
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/8/24 14:51
 */
public class BubbleSort extends Sort{

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

//    public static void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
//    }

    // for test


}
