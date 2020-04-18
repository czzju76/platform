package com.platform.demo.data_structure;

import com.platform.data_structure.SparseArray;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SparseArrayData {
    private int[][] sparseArray;
    private int sum = 0;
    public SparseArrayData(SparseArray sa){
        sparseArray = sa.getSparseArray();
    }

    public void display(){
        for (int i = 0; i < sparseArray.length; i++){
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();
    }
}
