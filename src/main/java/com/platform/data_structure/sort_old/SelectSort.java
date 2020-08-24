package com.platform.data_structure.sort_old;

public class SelectSort extends Sort{


    public int[] sort(int[] arr){
        if(arr.length<2)
            return arr;

        int length = arr.length;

        for (int i = 0; i < length; i++) {
            int index = i;
            for (int j = i+1; j < length; j++) {
                if(arr[j] < arr[index])
                    index = j;
            }
            if(index != i)
                swap(arr, i, index);
        }
        return arr;
    }
}
