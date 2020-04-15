package com.platform.io;

import java.io.*;

public class TextFileManager {

    private final static String LINESEPARATOR = "\r\n";

    /**
     * save string to text file.
     * @param writer:new OutputStreamWriter(new FileOutputStream("test.txt"))
     * @param text:"this is a test!"
     * @throws IOException
     */
    public static void store(Writer writer, String text) throws IOException {

        store0(new BufferedWriter(writer), text);
    }


    private static void store0(BufferedWriter bw, String text) throws IOException {
        try {
            bw.write(text);
            bw.flush();
        }finally {
            bw.close();
        }

    }

    /**
     * read string from text file
     * @param reader: new InputStreamWriter(new FileInputStream("test.txt"))
     * @return string from text file
     * @throws IOException
     */
    public static String load(Reader reader) throws IOException {
        return load0(new BufferedReader(reader));
    }


    private static String load0(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(LINESEPARATOR);
            }

            return sb.toString();
        }finally {
            br.close();
        }
    }

}
