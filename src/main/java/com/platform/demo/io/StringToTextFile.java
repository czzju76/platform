package com.platform.demo.io;

import com.platform.io.TextFileManager;

import java.io.*;

public class StringToTextFile {
    public static void main(String[] args) {
        //write();
        read();
    }

    private static void write(){
        try{
            TextFileManager.store(new OutputStreamWriter(new FileOutputStream("test.txt")), "this is a test!");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static void read(){
        try{
            String content = TextFileManager.load(new InputStreamReader(new FileInputStream("test.txt")));
            System.out.println("File Content:"+content);

        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
