package com.pengcheng.iotest;

import java.io.*;

/**
 * 3.相对我们前面的例子是直接用FileReader打开的文件，我们这次使用链接流，一般比较常用的都用链接流，
 *   所谓链接流就是就多次对流的封装，这样能更好的操作个管理数据，（比如我们利用DataInputStream
 *   （BufferedInputStream(FileInputStream)）将字节流层层包装后，我们可以读取readByte(),readChar()
 *   这样更加具体的操作，注意，该流属于字节流对字符进行操作，）
 *   字符流用CharArrayReader就可以了。
 *   下面的示例我们将用到j2se 5中的一个可变参数进行一个小度扩展。
 *   使用BufferedWriter 和BufferedReader用文件级联的方式进行写入，
 *   即将多个文件写入到同一文件中（自带缓冲区的输出输出流BufferedReader和BufferedWriter,
 *   该流最常用的属readLine()方法了，读取一行数据，并返回String）。
 * Created by pcliu on 16-11-29.
 */
public class FileConcatenateTest {

    public static void concennateFile(String...fileName) throws IOException {
        String str;

        //构建对该文件您的输入流
        BufferedWriter writer=new BufferedWriter(new FileWriter("files/test1_2"));

        for(String name: fileName){
            BufferedReader reader=new BufferedReader(new FileReader(name));
            while ((str=reader.readLine())!=null) {
                System.out.println(str);
                writer.write(str);
                writer.newLine();
            }
            writer.flush();
        }
    }

    public static void main(String[] args) throws IOException {
        concennateFile(new String[]{"files/test1", "files/test2"});
    }
}
