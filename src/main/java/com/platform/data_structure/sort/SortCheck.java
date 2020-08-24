package com.platform.data_structure.sort;

import java.util.Arrays;

/**
 * @Title: SortCheck
 * @Description:  对数器
 * 1.为了能够使用人工来检查，提供的是数量较小的数据集合      --- 数据集合中数据量较小，保证能人工检查
 * 2.通过给出大量数据集合，遍历了数据集合的各种可能性        --- 提供大量的数据集合，保证各种情况均遍历
 *
 * 对数器的概念和使用
 * 0，有一个你想要测的方法a，
 * 1，实现一个绝对正确但是复杂度不好的方法b，
 * 2，实现一个随机样本产生器
 * 3，实现比对的方法
 * 4，把方法a和方法b比对很多次来验证方法a是否正确。
 * 5，如果有一个样本使得比对出错，打印样本分析是哪个方法出错
 * 6，当样本数量很多时比对测试依然正确，可以确定方法a已经正确。
 *
 *
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/8/24 16:04
 */
public class SortCheck {
    /*
     * 支持测试类型
     * 1. BubbleSort  冒泡排序
     * 2. SelectionSort  选择排序
     * 3. InsertionSort  插入排序
     */
    private static String type = "InsertionSort";
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void concreteSort(int[] arr){
        if(type.equals("BubbleSort")){
            BubbleSort.sort(arr);
        }else if(type.equals("SelectionSort")){
            SelectionSort.sort(arr);
        }else if(type.equals("InsertionSort")){
            InsertionSort.sort(arr);
        }
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] origin = copyArray(arr1);
            concreteSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                printArray(arr1);
                printArray(arr2);
                printArray(origin);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        concreteSort(arr);
        printArray(arr);
    }
}
