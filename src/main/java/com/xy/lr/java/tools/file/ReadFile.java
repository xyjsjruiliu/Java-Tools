package com.xy.lr.java.tools.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by xylr on 16-1-20.
 */
public class ReadFile {
    public ReadFile() {
    }
    /**
     * 读取某个文件夹下的所有文件
     */
    public static boolean readfile(String filepath)
            throws FileNotFoundException, IOException {
        try {
            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("文件");
                System.out.println("name=" + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        System.out.println("path=" + readfile.getPath());
                        System.out.println("absolutepath="
                                + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());
                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            readfile("/home/xylr/Data/NewsEye/2014-10-01/");
        } catch (FileNotFoundException ex) {ex.printStackTrace();}
        catch (IOException ex) {ex.printStackTrace();}
        System.out.println("ok");
    }
}
