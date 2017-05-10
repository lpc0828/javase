package com.pengcheng.iotest;

import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by pcliu on 16-11-30.
 */
public class MyTree {

    public static void main(String[] args) {
        MadeTree mt = new MadeTree();
        try {
            File file = new File("/tmp/test");
            if (file.isDirectory() == false) {
                throw new Exception("不是目录!");
            }
            mt.made(file, 0, new LinkedList());

        } catch (Exception e) {
            System.out.println("用法: java MyTree 目录名");
            e.printStackTrace();
        }

    }
}

class MadeTree {
    public static String signTreeBranch = "├── ";
    public static String signTreeLastBranch = "└── ";
    public static String signTreeThroughBranch = "│  ";
    public static String signTreeNoneBranch = "     ";

    public static boolean isPrintFile = true;//true:显示文件  false:不显示文件


    public void made(File file, int num, LinkedList link) {
        File[] fileArray;
        if(MadeTree.isPrintFile == true){
            fileArray = file.listFiles();
        }else{
            fileArray = file.listFiles(new MyFileFilter());
        }

        Iterator it = link.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }

        if (fileArray == null) {
            //说明传进来的是空目录或文件
            System.out.println(file.getName());
        } else {
            //说明传进来的是有内容的目录
            System.out.println("" + file.getName() + "");

            //处理下一级目录
            if (link != null && link.size() > 0) {
                //如果父节点是分支则用signTreeThroughBranch代替
                if (link.getLast().equals(MadeTree.signTreeBranch)) {
                    link.removeLast();
                    link.addLast(MadeTree.signTreeThroughBranch);
                }
                //如果父节点是末支则用signTreeNoneBranch代替
                if (link.getLast().equals(MadeTree.signTreeLastBranch)) {
                    link.removeLast();
                    link.addLast(MadeTree.signTreeNoneBranch);
                }
            }

            link.addLast(MadeTree.signTreeBranch);
            for (int i = 0; i < fileArray.length; i++) {

                if (i != fileArray.length - 1) {
                    //处理成分支
                } else {
                    //处理成末支
                    link.removeLast();
                    link.addLast(MadeTree.signTreeLastBranch);
                }
                //此处要特别注意link是要clone的，要不就共享一个了
                made(fileArray[i], num + 1, (LinkedList) link.clone());
            }

        }

    }

}


/**
 * 文件过滤器，过滤掉不是目录的文件
 */
class MyFileFilter implements FileFilter {
    public boolean accept(File pathname) {
        if (pathname.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }
}
