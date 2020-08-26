package com.platform.data_structure.sort;

/**
 * @Title: BubbleSort
 * @Description: 堆排序，时间复杂度O(N*LogN)，额外空间复杂度O(1)
 * 算法说明：
 * 1、堆结构：
 *  1.1、堆是一棵完全二叉树的数组对象
 *  1.2、节点n的两个子节点为 2n+1,2n+2
 *  1.3、节点n的父节点为 (n-1)/2
 *  1.4、堆的运用：大根堆、小根堆；在java类库中PriorityQueue优先级队列就是使用堆结构
 *  1.5、建堆的代价：log1+log2+log3+...+log(n-1)=n,O(n)
 *  1.6、heapify代价：O(logN)
 *
 * 2、堆排序:
 *  2.1、先将数组形成大根堆
 *  2.2、堆顶数据与堆结构（数组）尾部进行交换，之后执行heapify操作
 *  2.3、依次执行2.2流程，则完成排序
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/8/25 14:51
 */
public class HeapSort extends Sort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
}
