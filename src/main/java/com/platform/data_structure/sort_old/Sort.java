package com.platform.data_structure.sort_old;

public abstract class Sort {
    public  abstract  int[] sort(int[] arr);
    protected void swap(int[] arr, int i, int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

}
