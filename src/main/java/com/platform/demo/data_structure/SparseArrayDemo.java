package com.platform.demo.data_structure;

import com.platform.data_structure.SparseArray;
import com.platform.demo.io.SampleObject;
import com.platform.io.BinaryFileManager;
import com.platform.serialize.Impl.JSONSerializer;
import com.platform.serialize.Serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SparseArrayDemo {
    public static void main(String[] args) {

        //write();
        read();
    }

    private static void write(){
        int[][] arr = new int[12][12];
        arr[2][3] = 3;
        arr[1][10] =2;

        SparseArray sparseArray = new SparseArray(arr);
        sparseArray.display();
        SparseArrayData sparseArrayData = new SparseArrayData(sparseArray);
        Serializer serializer = new JSONSerializer();
        try {
            BinaryFileManager.store(new FileOutputStream("sparseArray.data"), serializer.serialize(sparseArrayData));
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private  static void read(){
        Serializer serializer = new JSONSerializer();
        try {
            byte[] bytes = BinaryFileManager.load(new FileInputStream("sparseArray.data"));
            System.out.println(bytes);
            SparseArrayData sparseArrayData = serializer.deserialize(SparseArrayData.class, bytes);
            sparseArrayData.display();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
