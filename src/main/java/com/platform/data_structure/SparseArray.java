package com.platform.data_structure;

public class SparseArray {
    private int[][] sparseArray;
    private int sum = 0;
    public SparseArray(int[][] arr){
        initSparse(arr);
    }

    private void initSparse(int[][] arr){
        int rowNum = arr.length;
        int colNum = 0;
        if(rowNum>0)
            colNum = arr[0].length;
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(arr[i][j] != 0)
                    this.sum++;
            }
        }

        if(this.sum == 0)
            return;

        sparseArray = new int[sum+1][3];
        sparseArray[0][0] = rowNum;
        sparseArray[0][1] = colNum;
        sparseArray[0][2] = sum;
        int count = 1;
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(arr[i][j] != 0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count++][2] = arr[i][j];
                    if(count > sum)
                        return;
                }
            }
        }
    }

    public void display(){
        for (int i = 0; i < sparseArray.length; i++){
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();
    }

    public int[][] getSparseArray(){
        return sparseArray;
    }

}
