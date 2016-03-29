package com.xy.lr.java.tools.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xylr on 16-3-5.
 */
public class JFile {

    private JFile(){
        throw new Error("不要实例化我。");
    }

    /**
     *
     * @param files
     * @param format
     * @return
     */
    public static ArrayList<String> getAllLinesByFilePath (String files, String format) {
        ArrayList<String> lists = new ArrayList<String>();
        FindAllFileOnCatalogue findAllFileOnCatalogue = new FindAllFileOnCatalogue();

        for (File file : findAllFileOnCatalogue.getCatalogueList(new File(files))) {
            String str = getAllLines(file);

            lists.add(str);
        }

        return lists;
    }

    /**
     *
     * @param file
     * @param format
     * @return
     */
    public static ArrayList<String> getAllLines(File file,
                                                String format) {
        ArrayList<String> lines = new ArrayList<String>();
        InputStreamReader read = null;
        try {
            //以format格式读取文件内容
            read = new InputStreamReader(
                    new FileInputStream(file),format);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(read);
        String line;
        try {
            //按行读取数据
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            reader.close();
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
    /**
     * 获取文件中的所有数据
     * @param file
     * @return
     */
    public static String getAllLines(File file) {
        InputStreamReader read = null;
        try {
            read = new InputStreamReader(
                    new FileInputStream(file),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(read);
        String line;
        String temp = new String();
        try {
            while ((line = reader.readLine()) != null) {
                temp += line+"\n";
            }
            reader.close();
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * 文件保存
     * @param files
     * @param temp
     */
    public static void saveFiles(String files, String temp) {
        BufferedWriter writer = null;

        FileOutputStream writerStream = null;
        try {
            writerStream = new FileOutputStream(
                    new File(files));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            writer = new BufferedWriter(
                    new OutputStreamWriter(writerStream, "UTF-8"));
            writer.write(temp);

            writerStream.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param files
     * @param data
     * @param format
     */
    public static void saveFiles(String files,
                                 String data,
                                 String format) {
        BufferedWriter writer = null;

        FileOutputStream writerStream = null;
        try {
            writerStream = new FileOutputStream(
                    new File(files));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            writer = new BufferedWriter(
                    new OutputStreamWriter(writerStream, format));
            //写入数据
            writer.write(data);

            writerStream.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFiles(String files,
                                 ArrayList<String> datas,
                                 String format) {
        appendFile(files, datas);
    }

    /**
     * 给任意文件尾部追加一系列数据
     * @param fileName 文件名
     * @param datas 文件内容
     */
    public static void appendFile(String fileName, List<String> datas) {
        for(String data : datas) {
            appendFile(fileName, data);
        }
    }

    /**
     * 给任意的文件尾部追加写一条数据
     * @param fileName 文件名
     * @param data 文件内容
     */
    public static void appendFile(String fileName, String data){
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(data + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param sourceFile 输入文件目录
     * @param destFile 输出文件目录
     * @param destDiff 输出文件后缀
     */
    public static void containFile(String sourceFile, String destFile,
                                   String destDiff, String newPath) {
        FindAllFileOnCatalogue fina = new FindAllFileOnCatalogue();

        //输出和输入
        List<File> source = fina.getCatalogueList(new File(sourceFile));
        List<File> dest = fina.getCatalogueList(new File(destFile));

        //遍历输入文件目录, 如果输出目录存在, 则将文件移动到新的目录
        for(File file : source) {
            boolean flag = false;

            //查询输出文件目录中是否存在
            for(File s : dest) {
                String name;
                if(destDiff.equals("null")) {
                    name = s.getName();
                }else{
                    name = s.getName().substring(0, s.getName().lastIndexOf(destDiff) - 1);
                }
//                System.out.println(name);
                if(name.equals(file.getName()))
                    flag = true;
            }
            if(flag){
                File fnewpath = new File(newPath);
                //判断文件夹是否存在
                if(!fnewpath.exists()){
                    fnewpath.mkdirs();
                }
                //移动文件
                File news = new File(newPath + "/" + file.getName());
                file.renameTo(news);
            }
        }
    }

    /**
     * 使用默认文件后缀
     * @param sourceFile 输入文件目录
     * @param destFile 输出文件目录
     */
    public static void containFile(String sourceFile, String destFile, String newPath) {
        containFile(sourceFile, destFile, "null", newPath);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
//        String lines = getAllLines(new File("testData/auto.qq.com.20050721.xml"));

//        System.out.println(lines);
//        System.out.println("ad");

//        containFile("testData/", "testDataParsed/", "xml", "te/");

//        containFile("/home/xylr/Working/IdeaProjects/KnowLedgeBase/data",
//                "/home/xylr/Working/IdeaProjects/KnowLedgeBase/data_Chinese", "xml",
//                "/home/xylr/Working/IdeaProjects/KnowLedgeBase/data_ChineseParsed");
        appendFile("1","a");
    }
}
