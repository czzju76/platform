package com.platform.io;

import java.io.*;

public class BinaryFileManager {

    public static void store(OutputStream outputStream, byte[] bytes) throws IOException {

        store0(new BufferedOutputStream(outputStream), bytes);
    }

    /**
     * save byte[] to binary file
     * @param fileOutputStream: new FileOutputStream("test.data")
     * @param bytes:byte array
     * @throws IOException
     */
    public static void store(FileOutputStream fileOutputStream, byte[] bytes) throws IOException {

        store0(new BufferedOutputStream(fileOutputStream), bytes);
    }

    private static void store0(BufferedOutputStream bos, byte[] bytes) throws IOException {
        try {
            bos.write(bytes);
            bos.flush();
        }
        finally {
            bos.close();
        }
    }



    public static byte[] load(InputStream inputStream) throws  IOException {

        int size = inputStream.available();
        return load0(new BufferedInputStream(inputStream), size);
    }

    /**
     *
     * @param fileInputStream:
     * @return
     * @throws IOException
     */
    public static byte[] load(FileInputStream fileInputStream) throws  IOException {

        int size = fileInputStream.available();
        return load0(new BufferedInputStream(fileInputStream), size);
    }

    private static byte[] load0(BufferedInputStream bis, int size) throws  IOException {
        byte[] bytes = new byte[size];
        try {
            if (bis.read(bytes, 0, size) != -1)
                return bytes;
        }finally {
            bis.close();
        }
        return null;
    }
}
