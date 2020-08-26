package com.platform.data_structure.sort;

/**
 * @Title: Sort
 * @Description: 排序总结
 * 排序总结：
 * O(N^2)  :  选择排序、冒泡排序、插入排序（有实际使用场景）
 * O(N*logN): 归并排序、快速排序、堆排序
 * O(N)：桶排序、计数排序、基数排序；这组排序是基于数量集合的特征，例如知道数值区间为0~100，设置101个桶
 *
 * 稳定性排序：  冒泡排、插入排序、归并排序
 *
 * 工程中混合排序：
 * 1、排序类型是基础类型（int、short、long、char等），使用快速排序；对象类型使用归并排序（保持稳定性）
 * 2、如果是快速排序，当数量小于等于60，使用插入排序（插入排序的处理常量小）
 *
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/8/24 15:38
 */
public class Sort {
    public static void swap(int[] arr, int i, int j) {
/*
        //使用异或方法，需要注意不能对自身进行处理，即i!=j时正常，i=j时错误，切记！！！
        if(i==j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
*/
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
