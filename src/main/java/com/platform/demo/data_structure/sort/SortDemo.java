package com.platform.demo.data_structure.sort;

import com.platform.data_structure.sort.BubbleSort;
import com.platform.data_structure.sort.InsertSort;
import com.platform.data_structure.sort.SelectSort;

public class SortDemo {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for(int i =0; i < 8;i++) {
            arr[i] = (int)(Math.random() * 8000); //生成一个[0, 8000000) 数
        }
        display(arr);
        //冒泡排序法
        //BubbleSort sort = new BubbleSort();
        //选择排序
        //SelectSort sort = new SelectSort();

        //插入排序
        InsertSort sort = new InsertSort();
        arr = sort.sort(arr);
        display(arr);
    }

    private static void display(int[] arr){
        for (int i = 0; i < 8; i++) {
            System.out.printf("%d\t", arr[i]);
        }
        System.out.println();
    }
}
