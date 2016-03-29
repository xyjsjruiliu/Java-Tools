package com.xy.lr.java.tools.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xylr on 16-1-20.
 * @author xylr 查找一个目录下所有的文件
 */
public class FindAllFileOnCatalogue {

    // 文件夹下所有文件的List
    private List<File> fileList = new ArrayList<File>();
    // 文件目录的大小
    private long fileListSize = 0;
    // 文件目录中最大的文件大小
    private double MaximumFileSize = 0.0;

    private long fileListLength = 0;

    /**
     * getList
     */
    public List<File> getCatalogueList(File file) {
//		fileListLength = getCatalogueLength(file);
//		System.out.println(fileListLength);
        fileList = new ArrayList<File>();
        try {
            fileListSize = getCatalogueSizes(file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this.fileList;
    }

    /**
     * 获取一个文件的大小
     */
    public long getFileSizes(File file) {
        long fileSize = 0;
        if (file.exists()) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                fileSize = fis.available();
                fis.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("文件不存在");
        }
        return fileSize;
    }

    /**
     * 转换文件格式 转换成B、K、M、G格式
     */
    public static String FormetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

    /**
     * 递归求取目录文件个数
     */
    public long getCatalogueLength(File f) {
        long size = 0;
        File flist[] = f.listFiles();
        size = flist.length;
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getCatalogueLength(flist[i]);
                size--;
            }
        }
        return size;
    }

    /**
     * 获取文件夹下的文件总大小
     */
    private long getCatalogueSizes(File f) {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {//如果是目录
                size = size + getCatalogueSizes(flist[i]);
            } else {//如果是文件
                size = size + flist[i].length();
                fileList.add(flist[i]);
            }
        }
        return size;
    }

    /**
     * 获取文件夹下最大文件的大小
     */
    public long getMaximumSize() {
        long maxSize = 0;
        for (Iterator<File> i = fileList.iterator(); i.hasNext();) {
            File str = i.next();
            long size = getFileSizes(str);
            if (size >= maxSize) {
                maxSize = size;
            }
        }
        return maxSize;
    }

    /**
     * 获取最大文件的文件名
     * */
    public String getMaximumSizeFileName(){
        long maxSize = 0;
        String maxSizeFileName = "";
        for (Iterator<File> i = fileList.iterator(); i.hasNext();) {
            File str = i.next();
            long size = getFileSizes(str);
            if (size >= maxSize) {
                maxSize = size;
                maxSizeFileName = str.getAbsolutePath();
            }
        }
        return maxSizeFileName;
    }

    /**
     * 删除所有大于 MaxSize 的文件
     * */
    public void removeFileToNewPath(long MaxSize, String newPath){
        for (Iterator<File> i = fileList.iterator(); i.hasNext();) {
            File file = i.next();
            long size = getFileSizes(file);
            if (size > MaxSize){
                File fnewpath = new File(newPath);
                //判断文件夹是否存在
                if(!fnewpath.exists()){
                    fnewpath.mkdirs();
                }
                //将文件移到新文件里
                File fnew = new File(newPath + "/" +file.getName());
                file.renameTo(fnew);
            }
        }
    }

    /**
     * 获取文件夹下最小文件的大小
     */
    public long getMinimumSize() {
        long minSize = 0;
        for (Iterator<File> i = fileList.iterator(); i.hasNext();) {
            File str = i.next();
            long size = getFileSizes(str);
            if (size <= minSize) {
                minSize = size;
            }
        }
        return minSize;
    }

    /**
     *
     * */
}
