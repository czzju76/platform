package com.platform.demo.data_structure.sort;

import com.platform.data_structure.sort.BubbleSort;
import com.platform.data_structure.sort.InsertSort;
import com.platform.data_structure.sort.SelectSort;

public class SortDemo {
    public static void main(String[] args) {
        int[] arr = new int[8000];
        for(int i =0; i < 8000;i++) {
            arr[i] = (int)(Math.random() * 300); //生成一个[0, 8000000) 数
        }
        display(arr);

        int[] value = new int[300];
        display(value);
        for (int i = 0; i < 8000; i++) {
            value[arr[i]]++;
        }
        display(value);
        int count1=0;
        int count2=0;
        int count3=0;
        for (int i = 0; i < 300; i++) {
            if(value[i]>30)
                count1++;
            if(value[i]>20)
                count2++;
            if(value[i]<5)
                count3++;
        }
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
        //冒泡排序法
        //BubbleSort sort = new BubbleSort();
        //选择排序
        //SelectSort sort = new SelectSort();

        //插入排序
/*        InsertSort sort = new InsertSort();
        arr = sort.sort(arr);
        display(arr);*/
    }

    private static void display(int[] arr){
        for (int i = 0; i < 300; i++) {
            System.out.printf("%d\t", arr[i]);
        }
        System.out.println();
    }
}
