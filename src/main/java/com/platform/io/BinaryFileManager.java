package com.platform.io;

import java.io.*;

public class BinaryFileManager {

    public void store(OutputStream outputStream, byte[] bytes) throws IOException {

        store0(new BufferedOutputStream(outputStream), bytes);
    }

    public void store(FileOutputStream fileOutputStream, byte[] bytes) throws IOException {

        store0(new BufferedOutputStream(fileOutputStream), bytes);
    }

    private void store0(BufferedOutputStream bos, byte[] bytes) throws IOException {
        bos.write(bytes);
        bos.flush();
    }



    public byte[] load(InputStream inputStream) throws  IOException {

        int size = inputStream.available();
        return load0(new BufferedInputStream(inputStream), size);
    }

    public byte[] load(FileInputStream fileInputStream) throws  IOException {

        int size = fileInputStream.available();
        return load0(new BufferedInputStream(fileInputStream), size);
    }

    private byte[] load0(BufferedInputStream bis, int size) throws  IOException {
        byte[] bytes = new byte[size];
        if(bis.read(bytes, 0, size) != -1)
            return bytes;
        return null;
    }
}
