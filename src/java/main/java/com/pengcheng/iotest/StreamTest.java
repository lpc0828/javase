package com.pengcheng.iotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by pcliu on 16-11-29.
 */
public class StreamTest {


    public static void count() {
        //TODO 自动生成的方法存根
        int count = 0;  //统计文件字节长度
        InputStream streamReader = null;   //文件输入流
        try {
            streamReader = new FileInputStream(new File("files/01.jpg"));
              /*1.new File()里面的文件地址也可以写成D:\\David\\Java\\java 高级进阶\\files\\tiger.jpg,前一个\是用来对后一个
               * 进行转换的，FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。
              */
            while (streamReader.read() != -1) {  //读取文件字节，并递增指针到下一个字节
                count++;
            }
            System.out.println("---长度是： " + count + " 字节");
        } catch (final IOException e) {
            //TODO 自动生成的 catch 块
            e.printStackTrace();
        } finally {
            try {
                streamReader.close();
            } catch (IOException e) {
                //TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    }

    public static void testStreamRead() {
        InputStream streamReader = null;   //文件输入流
        try {
            streamReader = new FileInputStream(new File("files/test1"));
              /*1.new File()里面的文件地址也可以写成D:\\David\\Java\\java 高级进阶\\files\\tiger.jpg,前一个\是用来对后一个
               * 进行转换的，FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。
              */
            byte[] buffer = new byte[4];
            int length = 0;
            while ((length = streamReader.read(buffer, 0, buffer.length)) != -1) {  //读取文件字节，并递增指针到下一个字节
                String str = new String(buffer,0, length);
                System.out.print(str);
            }
        } catch (final IOException e) {
            //TODO 自动生成的 catch 块
            e.printStackTrace();
        } finally {
            try {
                streamReader.close();
            } catch (IOException e) {
                //TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        count();
        testStreamRead();
    }
}