package com.platform.demo.io;


import com.platform.io.BinaryFileManager;
import com.platform.serialize.Impl.JSONSerializer;
import com.platform.serialize.Serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ObjectToBinaryFile {
    public static void main(String[] args) {
        //write();
        read();
    }

    private static void write(){
        SampleObject object = new SampleObject("Lyon Chen", 44);
        Serializer serializer = new JSONSerializer();
        try {
            BinaryFileManager.store(new FileOutputStream("test.data"), serializer.serialize(object));
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private  static void read(){
        Serializer serializer = new JSONSerializer();
        try {
            byte[] bytes = BinaryFileManager.load(new FileInputStream("test.data"));
            System.out.println(bytes);
            SampleObject object = serializer.deserialize(SampleObject.class, bytes);
            System.out.println("name: "+ object.getName() +"; age: "+ object.getAge());
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
