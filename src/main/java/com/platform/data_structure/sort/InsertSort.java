package com.platform.data_structure.sort;

public class InsertSort extends Sort {

    public int[] sort(int[] arr) {
        if(arr.length<2)
            return arr;

        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            index = i;
            while(index>0){
                if(arr[index-1]>arr[index]){
                    swap(arr, index-1, index);
                }
                index--;
            }
        }

        return arr;
    }
}
