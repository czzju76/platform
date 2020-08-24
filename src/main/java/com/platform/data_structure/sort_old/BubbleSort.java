package com.platform.data_structure.sort_old;

public class BubbleSort extends Sort {
    public int[] sort(int[] arr){
        if(arr.length<2)
            return arr;

        int length = arr.length;
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j+1);
                    flag = true;
                }
            }
            if(!flag)
                break;

        }
        return arr;
    }


}
