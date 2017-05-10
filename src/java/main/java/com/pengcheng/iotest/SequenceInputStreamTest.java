package com.pengcheng.iotest;

import java.io.*;
import java.util.Vector;

/**
 * 有些情况下，当我们需要从多个输入流中向程序读入数据。
 * 此时，可以使用合并流，将多个输入流合并成一个SequenceInputStream流对象。
 * SequenceInputStream会将与之相连接的流集组合成一个输入流并从第一个输入流开始读取，
 * 直到到达文件末尾，接着从第二个输入流读取，依次类推，
 * 直到到达包含的最后一个输入流的文件末尾为止。
 * 合并流的作用是将多个源合并合一个源。
 * 其可接收枚举类所封闭的多个字节流对象。
 * Created by pcliu on 16-11-29.
 */
public class SequenceInputStreamTest {

    private static String fileMainPath = "files/";
    private static void doSequence() {
        System.out.println(new File(fileMainPath).getAbsolutePath());
        InputStream sis = null;
        OutputStream outputStream = null;

        Vector<InputStream> collectins = new Vector<InputStream>();
        try {
            collectins.add(new FileInputStream(fileMainPath+"test1"));
            collectins.add(new FileInputStream(fileMainPath+"test2"));

            sis = new SequenceInputStream(collectins.elements());
            outputStream = new BufferedOutputStream(new FileOutputStream(fileMainPath+"test1_2"));
            // 读写数据
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = sis.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
                outputStream.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        doSequence();
    }
}
