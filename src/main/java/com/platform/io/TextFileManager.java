package com.platform.io;

import java.io.*;

public class TextFileManager {

    public void store(Writer writer, String text) throws IOException {

        store0(new BufferedWriter(writer), text);
    }


    private void store0(BufferedWriter bw, String text) throws IOException {
        bw.write(text);
        bw.flush();
    }

    public String load(Reader reader) throws IOException {

        return load0(new BufferedReader(reader));
    }


    private String load0(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        int limit =0;
        int length;
        while(true){
            sb.append(br.readLine());
            length = sb.length();
            if(length == limit)
                break;
            limit = length;
        }

        return sb.toString();
    }

}
