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
