package com.platform.data_structure.sort;

/**
 * @Title: SelectionSort
 * @Description: 选择排序
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/8/24 16:53
 */
public class SelectionSort extends Sort{

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }


}
