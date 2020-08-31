package com.platform.data_structure.sort;

/**
 * @Title: InsertionSort
 * @Description: 插入排序，时间复杂度O(N^2)，额外空间复杂度O(1)
 * 算法思想：
 * 1、形成一个小的有序数组，将后续数依次放入有序数组中正确的位置
 * 2、时间复杂度最好为O(N),最差为O(N^2)，记为O(N^2);
 * 3、但数据较少（工程上小于60）时，插入排序最快（插入排序的处理常量小）。
 *
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
