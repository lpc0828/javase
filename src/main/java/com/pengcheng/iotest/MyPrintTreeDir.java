package com.pengcheng.iotest;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by pcliu on 16-11-30.
 */
public class MyPrintTreeDir {

    public static String SignTreeBranch = "├── ";
    public static String SignTreeLastBranch = "└── ";
    public static String SignTreeThroughBranch = "│  ";
    public static String SignTreeNoneBranch = "     ";

    public void printFileName(String name, LinkedList<String> linkList) {
        String lineString = "";
        if (linkList.isEmpty()) {
            lineString = StringUtils.join(name);
        } else {
            lineString = StringUtils.join(StringUtils.join(linkList), name);
        }
        System.out.println(lineString);
    }

    public void readFiles(String filePath, LinkedList<String> linkList) {

        File file = new File(filePath);

        File[] files = file.listFiles();

        for (int i=0; i<files.length; i++) {
            if (files[i].isDirectory()) {
                printFileName(files[i].getName(), linkList);
                readFiles(files[i].getAbsolutePath(), linkList);
            } else {
                printFileName(files[i].getName(), linkList);
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "/tmp/test";
        MyPrintTreeDir rd = new MyPrintTreeDir();
        String[] arg = filePath.split("/");
        System.out.println(arg[arg.length-1]);
        rd.readFiles(filePath, new LinkedList<String>());
    }
}
